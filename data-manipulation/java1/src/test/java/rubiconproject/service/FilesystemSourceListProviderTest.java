package rubiconproject.service;

import org.junit.Test;
import rubiconproject.model.Source;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * {@link FilesystemSourceListProvider} tests.
 *
 * @author vkolodrevskiy
 */
public class FilesystemSourceListProviderTest {
    @Test
    public void testDirectoryDoesNotExist() {
        FilesystemSourceListProvider provider = new FilesystemSourceListProvider();
        assertTrue(provider.getInputSources(new File("/i/do/not/exist")).isEmpty());
    }

    @Test
    public void testDirectoryExists() {
        FilesystemSourceListProvider provider = new FilesystemSourceListProvider();
        List<Source> sources = provider.getInputSources(
                new File(getClass().getClassLoader().getResource("datafilereader").getFile()));
        assertEquals(2, sources.size());
    }
}
