package rubiconproject.reader;

import org.junit.Test;
import rubiconproject.model.SourceType;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * {@link FileReaderFactory} tests.
 *
 * @author vkolodrevskiy
 */
public class DataFileReaderFactoryTest {
    @Test(expected = IOException.class)
    public void getReader1() throws Exception {
        FileReaderFactory factory = new FileReaderFactory();
        factory.getReader(SourceType.CSV, new File("/i/do/not/exist"));
    }

    @Test(expected = IOException.class)
    public void getReader2() throws Exception {
        FileReaderFactory factory = new FileReaderFactory();
        factory.getReader(SourceType.JSON, new File("/i/do/not/exist"));
    }
}
