package rubiconproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Source;
import rubiconproject.model.SourceType;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Retrieves list of source files from filesystem.
 *
 * @author vkolodrevskiy
 */
public class FilesystemSourceListProvider {
    private final Logger log = LoggerFactory.getLogger(FilesystemSourceListProvider.class);

    /**
     * Retrieves {@code List} of data sources. Only CSV abd JSON files
     * are valid. No folder recursion is supported.
     *
     * @param inputDir input directory.
     * @return {@code List} of data sources
     */
    public List<Source> getInputSources(File inputDir) {
        log.info("Input directory [{}].", inputDir.getPath());

        List<Source> sources = new ArrayList<>();
        File[] listOfFiles = inputDir.listFiles();
        if (listOfFiles == null) {
            log.error("[{}] pathname does not denote a directory, or an I/O error occurs.", inputDir.getPath());
            return Collections.emptyList();
        }
        for (File file : listOfFiles) {
            if (file.getName().toLowerCase().endsWith(SourceType.JSON.getFileExtension())) {
                sources.add(new Source(file, SourceType.JSON));
            } else if (file.getName().toLowerCase().endsWith(SourceType.CSV.getFileExtension())) {
                sources.add(new Source(file, SourceType.CSV));
            }
        }

        return sources;
    }
}
