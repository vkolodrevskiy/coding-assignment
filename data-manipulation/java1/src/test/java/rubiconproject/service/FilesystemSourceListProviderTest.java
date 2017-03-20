package rubiconproject.service;

import org.junit.Test;

import java.io.File;

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
}
