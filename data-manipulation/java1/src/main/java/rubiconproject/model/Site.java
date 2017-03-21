package rubiconproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents site entry from csv or json file.
 *
 * @author vkolodrevskiy
 */
public class Site {
    @SerializedName("site_id")
    private Integer id;
    private String name;
    private String keywords;
    private Boolean mobile;
    private Integer score;

    public Site() {
    }

    public Site(Integer id, String name, Boolean mobile, Integer score) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
