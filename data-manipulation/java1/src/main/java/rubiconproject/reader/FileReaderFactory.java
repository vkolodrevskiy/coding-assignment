package rubiconproject.reader;

import rubiconproject.model.SourceType;

/**
 * Retrieve specific {@link FileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class FileReaderFactory {
    private final FileReader csvFileReader = new CsvFileReader();
    private final FileReader jsonFileReader = new JsonFileReader();

    public FileReader getReader(SourceType sourceType) {
        switch (sourceType) {
            case CSV: return csvFileReader;
            case JSON: return jsonFileReader;
            default: throw new IllegalArgumentException(String.format("Source type is not supported %s", sourceType));
        }
    }
}
