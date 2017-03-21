package rubiconproject.reader;

import rubiconproject.model.SourceType;

import java.io.File;
import java.io.IOException;

/**
 * Retrieve specific {@link DataFileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class FileReaderFactory {
    public DataFileReader getReader(SourceType sourceType, File file) throws IOException {
        switch (sourceType) {
            case CSV: return new CsvDataFileReader(file);
            case JSON: return new JsonDataFileReader(file);
            default: throw new IllegalArgumentException(String.format("Source type is not supported %s", sourceType));
        }
    }
}
