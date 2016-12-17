package com;

import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class Query {
    private List keyWords;
    private Integer queryNumber;

    public Query(List queryKeywords, int queryNumber ) {
        this.keyWords = queryKeywords;
        this.queryNumber = queryNumber;
    }

    public List getKeyWords() {
        return keyWords;
    }

    public String queryNumber() {
        return "Q"+ queryNumber;
    }
}
