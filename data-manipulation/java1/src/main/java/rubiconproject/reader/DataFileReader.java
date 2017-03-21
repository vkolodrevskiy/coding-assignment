package rubiconproject.reader;

import rubiconproject.model.Site;

import java.io.Closeable;
import java.io.File;
import java.util.List;

/**
 * Reading input files.
 *
 * @author vkolodrevskiy
 */
public interface DataFileReader {
    List<Site> read(File file);
}
