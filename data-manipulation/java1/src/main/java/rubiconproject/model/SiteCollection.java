package rubiconproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Collection of sites, identified by id.
 *
 * @author vkolodrevskiy
 */
public class SiteCollection {
    @SerializedName("collectionId")
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
