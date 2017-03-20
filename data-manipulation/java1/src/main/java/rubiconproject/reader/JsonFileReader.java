package rubiconproject.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Site;
import rubiconproject.service.FilesystemSourceListProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JSON {@link FileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class JsonFileReader implements FileReader {
    private final Logger log = LoggerFactory.getLogger(FilesystemSourceListProvider.class);

    private ObjectMapper objectMapper;

    public JsonFileReader() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Site> read(File file) {
        try {
            return objectMapper.readValue(file, new TypeReference<ArrayList<Site>>() {});
        } catch (IOException e) {
            log.error("JSON file parse error, file {}, error {}", file.getPath(), e);
            return Collections.emptyList();
        }
    }
}
