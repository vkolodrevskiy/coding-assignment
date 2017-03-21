package rubiconproject.reader;

import rubiconproject.model.Site;

import java.io.File;
import java.util.List;

/**
 * Reading input files.
 *
 * @author vkolodrevskiy
 */
public interface DataFileReader {
    /**
     * Read sites from data file.
     *
     * @param file object representing file to read.
     * @return {@code List} of sites.
     */
    List<Site> read(File file);
}
