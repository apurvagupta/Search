package com;

import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class WebAppPage extends Relevance {

    private List keywords;
    private Integer pageNumber;
    private Integer relevance;

    public WebAppPage(List keywords, Integer pageNumber) {
        this.keywords = keywords;
        this.pageNumber = pageNumber;
    }

    public Integer queryRelevance(Query query){
        relevance = calculateRelevance(query.getKeyWords(), keywords);
        return relevance;
    }


    public String getPageNumber() {
        return "P"+ pageNumber;
    }
}
