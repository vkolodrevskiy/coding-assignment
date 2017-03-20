package rubiconproject.service;

import rubiconproject.model.Site;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link KeywordService} dummy implementation.
 *
 * @author vkolodrevskiy
 */
public class DummyKeywordService implements KeywordService {

    private final Map<Integer, String> keywords = new HashMap<Integer, String>() {{
        put(0, "yoga,gym,fitness,club");
        put(1, "movie,theatre");
        put(2, "sport,fan,game");
        put(3, "concert,tickets");
        put(4, "food,restaurant,bar,burger");
    }};

    @Override
    public String resolveKeywords(Site site) {
        return keywords.get(site.getId() % keywords.size());
    }
}
