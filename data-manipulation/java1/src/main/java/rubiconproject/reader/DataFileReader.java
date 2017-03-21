package rubiconproject.reader;

import rubiconproject.model.Site;

import java.io.Closeable;

/**
 * Reading input files.
 *
 * @author vkolodrevskiy
 */
public interface DataFileReader extends Iterable<Site>, Closeable {
}
