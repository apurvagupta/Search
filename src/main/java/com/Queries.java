package com;

import java.util.*;

/**
 * Created by apurvagu on 16/12/16.
 */
public class Queries {
    private List<Query> queries = new ArrayList<Query>();

    public Queries(Query ...query) {
        Collections.addAll(queries, query);
    }

    public Map searchResultsIn(WebAppPages webAppPages) {
        Map result = new TreeMap();
        for (Query query : queries) {
            result.put(query.queryNumber(), webAppPages.getPageNumbersWith(query));
        }
        return result;
    }
}
