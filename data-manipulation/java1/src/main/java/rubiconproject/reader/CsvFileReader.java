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
import java.util.ArrayList;
import java.util.List;

/**
 * CSV {@link DataFileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class CsvFileReader implements DataFileReader {
    private final Logger log = LoggerFactory.getLogger(FilesystemSourceListProvider.class);

    private static final String SITE_ID = "id";
    private static final String SITE_NAME = "name";
    private static final String SITE_IS_MOBILE = "is mobile";
    private static final String SITE_SCORE = "score";

    public CsvFileReader() {
    }

    @Override
    public List<Site> read(File file) {
        List<Site> sites = new ArrayList<>();

        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(SITE_ID, SITE_NAME, SITE_IS_MOBILE, SITE_SCORE);
        try (
                FileReader fileReader = new FileReader(file);
                CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
        ) {
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                Site site = new Site(Integer.parseInt(record.get(SITE_ID)),
                        record.get(SITE_NAME),
                        Boolean.parseBoolean(record.get(SITE_IS_MOBILE)),
                        Integer.parseInt(record.get(SITE_SCORE)));
                sites.add(site);
            }
        } catch (IOException e) {
            log.error("CSV file parse error, file {}, error {}", file.getPath(), e);
        }

        return sites;
    }
}
