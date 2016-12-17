package com;

import java.util.Collections;
import java.util.List;

/**
 * Created by apurvagu on 17/12/16.
 */
public abstract class Relevance {

    private final Integer RELEVANCE_CONST = 8;
    public Integer calculateRelevance(List queryKeywords, List webAppPageKeywords) {
        Collections.disjoint(webAppPageKeywords, queryKeywords);
        return Collections.disjoint(webAppPageKeywords, queryKeywords)? 0 : calculate(queryKeywords, webAppPageKeywords);
    }

    protected Integer calculate(List<String>queryKeywords, List<String> webAppPageKeywords){
        int relevance =0;
        for(String webAppPageKeyword:webAppPageKeywords){
            if(queryKeywords.contains(webAppPageKeyword)){
                relevance += (RELEVANCE_CONST - queryKeywords.indexOf(webAppPageKeyword)) * (RELEVANCE_CONST - webAppPageKeywords.indexOf(webAppPageKeyword));
            }
        }
        return relevance;
    }
}
