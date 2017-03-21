package rubiconproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Site;
import rubiconproject.model.SiteCollection;
import rubiconproject.model.Source;
import rubiconproject.reader.DataFileReader;
import rubiconproject.reader.FileReaderFactory;

import java.io.File;
import java.util.ArrayList;
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

    public SiteDataProcessor() {
        sourceListProvider = new FilesystemSourceListProvider();
        keywordService = new DummyKeywordService();
        fileReaderFactory = new FileReaderFactory();
    }

    public void processFolder(File inputDirectory) {
        List<Site> sites = new ArrayList<>();
        List<Source> sources = sourceListProvider.getInputSources(inputDirectory);
        for (Source source : sources) {
            sites.addAll(readRawEntries(source));
        }

        // collections.addAll(sources.stream().map(source -> fileReaderFactory.getReader(source.getType())));
    }

    private List<Site> readRawEntries(Source source) {
        //DataFileReader reader = fileReaderFactory.getReader(source.getType());
        //return reader.read(source.getFile());
        return null;
    }
}
