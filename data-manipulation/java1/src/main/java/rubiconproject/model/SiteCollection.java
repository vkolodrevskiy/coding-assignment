package rubiconproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Collection of sites, identified by id.
 *
 * @author vkolodrevskiy
 */
public class SiteCollection {
    @JsonProperty("collectionId")
    private String id;
    private List<Site> sites;

    public SiteCollection(String id, List<Site> sites) {
        this.id = id;
        this.sites = sites;
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
