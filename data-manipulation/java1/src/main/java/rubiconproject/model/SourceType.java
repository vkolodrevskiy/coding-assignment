package rubiconproject.model;

/**
 * Represents input data source types.
 *
 * @author vkolodrevskiy
 */
public enum SourceType {
    CSV("csv"),
    JSON("json");

    private String fileExtension;

    SourceType(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }
}
