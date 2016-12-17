package com;

import java.util.Map;

/**
 * Created by apurvagu on 16/12/16.
 */
public class SearchEngine {
    private Queries queries;
    private WebAppPages webAppPages;

    public SearchEngine(Queries queries, WebAppPages webAppPages) {
        this.queries = queries;
        this.webAppPages = webAppPages;
    }

    public Map search() {
        Map result = queries.searchResultsIn(webAppPages);
        return result;
    }
}
