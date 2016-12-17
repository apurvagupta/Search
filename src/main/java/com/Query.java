package com;

import java.util.List;

import static com.SearchEngine.MAXIMUM_WEIGHT;

/**
 * Created by apurvagu on 16/12/16.
 */
public class Query {
    private List keyWords;
    private Integer queryNumber;

    public Query(List queryKeywords, int queryNumber ) {
        this.keyWords = validateKeyWordSize(queryKeywords);
        this.queryNumber = queryNumber;
    }
    private List validateKeyWordSize(List keywords) {
        return keywords.size()> MAXIMUM_WEIGHT? keywords.subList(0,MAXIMUM_WEIGHT): keywords;
    }

    public List getKeyWords() {
        return keyWords;
    }

    public String queryNumber() {
        return "Q"+ queryNumber;
    }
}
