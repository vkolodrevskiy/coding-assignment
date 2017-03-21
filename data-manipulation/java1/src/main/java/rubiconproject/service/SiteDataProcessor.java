package rubiconproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Site;
import rubiconproject.model.SiteCollection;
import rubiconproject.model.Source;
import rubiconproject.reader.DataFileReader;
import rubiconproject.reader.FileReaderFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reads folder.
 *
 * @author vkolodrevskiy
 */
public class SiteDataProcessor {
    private final Logger log = LoggerFactory.getLogger(SiteDataProcessor.class);

    private final FilesystemSourceListProvider sourceListProvider;
    private final KeywordService keywordService;
    private final FileReaderFactory fileReaderFactory;
    private final ObjectMapper objectMapper;

    public SiteDataProcessor() {
        this.sourceListProvider = new FilesystemSourceListProvider();
        this.keywordService = new DummyKeywordService();
        this.fileReaderFactory = new FileReaderFactory();
        this.objectMapper = new ObjectMapper();
    }

    public void processFolder(File inputDirectory, File output) {
        List<Source> sources = sourceListProvider.getInputSources(inputDirectory);
        for (Source source : sources) {
            processSource(source, output);
        }
    }

    private void processSource(Source source, File output) {
        DataFileReader reader = fileReaderFactory.getReader(source.getType());
        List<Site> sites = reader.read(source.getFile()).stream().map(this::populateSiteKeywords).collect(Collectors.toList());
        SiteCollection collection = new SiteCollection(source.getFile().getName(), sites);
        try (PrintWriter pw = new PrintWriter(new FileWriter(output, true))) {
            pw.println(objectMapper.writer().writeValueAsString(collection));
        } catch (IOException e) {
            log.error("Error while processing sites data.", e);
        }
    }

    private Site populateSiteKeywords(Site site) {
        site.setKeywords(keywordService.resolveKeywords(site));
        return site;
    }
}
