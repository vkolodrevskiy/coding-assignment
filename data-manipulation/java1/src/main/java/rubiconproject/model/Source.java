package rubiconproject.model;

import java.io.File;

/**
 * Represents data source.
 *
 * @author vkolodrevskiy
 */
public class Source {
    private File file;
    private SourceType type;

    public Source(File file, SourceType type) {
        this.file = file;
        this.type = type;
    }

    public File getFile() {
        return file;
    }

    public SourceType getType() {
        return type;
    }
}
