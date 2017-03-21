package rubiconproject.reader;

import org.junit.Test;
import rubiconproject.model.Site;
import rubiconproject.model.SourceType;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * {@link JsonFileReader} and {@link CsvFileReader} tests.
 *
 * @author vkolodrevskiy
 */
public class DataFileReaderTest {
    @Test
    public void testReadJson() throws Exception {
        DataFileReader reader = new FileReaderFactory().getReader(SourceType.JSON);
        List<Site> sites = reader.read(new File(getClass().getClassLoader().getResource("datafilereader/input.json").getFile()));
        assertEquals(4, sites.size());
    }

    @Test
    public void testReadJsonNegative() throws Exception {
        DataFileReader reader = new FileReaderFactory().getReader(SourceType.JSON);
        List<Site> sites = reader.read(new File("/i/do/not/exist"));
        assertTrue(sites.isEmpty());
    }

    @Test
    public void testReadCsv() throws Exception {
        DataFileReader reader = new FileReaderFactory().getReader(SourceType.CSV);
        List<Site> sites = reader.read(new File(getClass().getClassLoader().getResource("datafilereader/input.csv").getFile()));
        assertEquals(3, sites.size());
    }

    @Test
    public void testReadCsvNegative() throws Exception {
        DataFileReader reader = new FileReaderFactory().getReader(SourceType.CSV);
        List<Site> sites = reader.read(new File("/i/do/not/exist"));
        assertTrue(sites.isEmpty());
    }
}
