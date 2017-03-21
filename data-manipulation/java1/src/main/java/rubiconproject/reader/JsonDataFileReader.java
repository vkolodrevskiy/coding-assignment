package rubiconproject.reader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rubiconproject.model.Site;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * JSON {@link DataFileReader} implementation.
 *
 * @author vkolodrevskiy
 */
public class JsonDataFileReader implements DataFileReader {
    private final Logger log = LoggerFactory.getLogger(JsonDataFileReader.class);

    private FileReader fileReader;
    private JsonArray jsonArray;

    private JsonDataFileReader() {}

    public JsonDataFileReader(File file) throws FileNotFoundException {
        this.fileReader = new FileReader(file);
        this.jsonArray = new JsonParser().parse(fileReader).getAsJsonArray();
    }

    @Override
    public Iterator<Site> iterator() {
        Iterator iterator = jsonArray.iterator();
        Gson gson = new Gson();

        return new Iterator<Site>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Site next() {
                return gson.fromJson((JsonElement) iterator.next(), Site.class);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void close() throws IOException {
        fileReader.close();
    }
}
