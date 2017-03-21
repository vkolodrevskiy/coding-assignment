package rubiconproject.reader;

import rubiconproject.model.SourceType;

/**
 * Retrieve specific {@link DataFileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class FileReaderFactory {
    private final DataFileReader csvFileReader = new CsvFileReader();
    private final DataFileReader jsonFileReader = new JsonFileReader();

    public DataFileReader getReader(SourceType sourceType) {
        switch (sourceType) {
            case CSV: return csvFileReader;
            case JSON: return jsonFileReader;
            default: throw new IllegalArgumentException(String.format("Source type is not supported %s", sourceType));
        }
    }
}
