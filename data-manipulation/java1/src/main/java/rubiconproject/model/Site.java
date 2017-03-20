package rubiconproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an entry from csv or json file.
 *
 * @author vkolodrevskiy
 */
public class Site {

    @JsonProperty("site_id")
    private Long id;
    private String name;
    private String keywords;
    private Boolean mobile;
    private Double score;

    public Site() {
    }

    public Site(Long id, String name, Boolean mobile, Double score) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
