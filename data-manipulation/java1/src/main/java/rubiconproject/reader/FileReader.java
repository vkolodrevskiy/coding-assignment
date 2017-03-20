package rubiconproject.reader;

import rubiconproject.model.Site;

import java.io.File;
import java.util.List;

/**
 * General contract of reading input files
 */
public interface FileReader {
    List<Site> read(File file);
}
