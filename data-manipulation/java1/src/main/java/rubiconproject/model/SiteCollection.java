package rubiconproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * SiteCollection of entries.
 *
 * @author vkolodrevskiy
 */
public class SiteCollection {
    @JsonProperty("collectionId")
    private String id;
    private List<Site> sites;

    public SiteCollection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
