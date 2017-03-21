package rubiconproject.service;

import com.google.gson.Gson;
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
import java.util.LinkedList;
import java.util.List;

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
    private final Gson gson;

    public SiteDataProcessor() {
        this.sourceListProvider = new FilesystemSourceListProvider();
        this.keywordService = new DummyKeywordService();
        this.fileReaderFactory = new FileReaderFactory();
        this.gson = new Gson();
    }

    public void processFolder(File inputDirectory, File output) {
        List<Source> sources = sourceListProvider.getInputSources(inputDirectory);
        for (Source source : sources) {
            processSource(source, output);
        }
    }

    private void processSource(Source source, File output) {
        try (DataFileReader reader = fileReaderFactory.getReader(source.getType(), source.getFile());
             PrintWriter pw = new PrintWriter(new FileWriter(output))) {
            List<Site> sites = new LinkedList<>();
            for (Site site : reader) {
                site.setKeywords(keywordService.resolveKeywords(site));
                sites.add(site);
            }
            SiteCollection collection = new SiteCollection(source.getFile().getName(), sites);
            pw.println(gson.toJson(collection));
        } catch (IOException e) {
            log.error("Error while processing sites data.", e);
        }
    }
}
