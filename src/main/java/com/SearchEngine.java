package com;

import java.util.Map;

/**
 * Created by apurvagu on 16/12/16.
 */
public class SearchEngine {
    private WebAppPages webAppPages;
    public static final Integer MAXIMUM_WEIGHT = 8;

    public SearchEngine(WebAppPages webAppPages) {
        this.webAppPages = webAppPages;
    }

    public Map search(Queries queries) {
        Map result = queries.searchResultsIn(webAppPages);
        return result;
    }
}
