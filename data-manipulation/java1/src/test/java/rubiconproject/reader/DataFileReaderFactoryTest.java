package rubiconproject.reader;

import org.junit.Test;
import rubiconproject.model.SourceType;

import static org.junit.Assert.assertTrue;

/**
 * {@link FileReaderFactory} tests.
 *
 * @author vkolodrevskiy
 */
public class DataFileReaderFactoryTest {
    @Test
    public void testGetReader() throws Exception {
        FileReaderFactory factory = new FileReaderFactory();
        assertTrue(factory.getReader(SourceType.CSV).getClass() == CsvFileReader.class);
        assertTrue(factory.getReader(SourceType.JSON).getClass() == JsonFileReader.class);
    }
}
