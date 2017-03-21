package rubiconproject.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Site;
import rubiconproject.service.FilesystemSourceListProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * CSV {@link DataFileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class CsvDataFileReader implements DataFileReader {
    private final Logger log = LoggerFactory.getLogger(FilesystemSourceListProvider.class);

    private static final String SITE_ID = "id";
    private static final String SITE_NAME = "name";
    private static final String SITE_IS_MOBILE = "is mobile";
    private static final String SITE_SCORE = "score";

    private CSVParser csvFileParser;

    private CsvDataFileReader() {
    }

    public CsvDataFileReader(File file) throws IOException {
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(SITE_ID, SITE_NAME, SITE_IS_MOBILE, SITE_SCORE);
        this.csvFileParser = new CSVParser(new FileReader(file), csvFileFormat);
    }

    @Override
    public Iterator<Site> iterator() {
        Iterator<CSVRecord> iterator = csvFileParser.iterator();

        return new Iterator<Site>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Site next() {
                CSVRecord record = iterator.next();
                return new Site(Integer.parseInt(record.get(SITE_ID)),
                        record.get(SITE_NAME),
                        Boolean.parseBoolean(record.get(SITE_IS_MOBILE)),
                        Integer.parseInt(record.get(SITE_SCORE)));
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void close() throws IOException {
        csvFileParser.close();
    }
}
