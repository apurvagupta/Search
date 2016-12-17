package com;

import java.util.Collections;
import java.util.List;

import static com.SearchEngine.MAXIMUM_WEIGHT;

/**
 * Created by apurvagu on 17/12/16.
 */
public abstract class Relevance {

    public Integer calculateRelevance(List queryKeywords, List webAppPageKeywords) {
        return Collections.disjoint(webAppPageKeywords, queryKeywords)? 0 : calculate(queryKeywords, webAppPageKeywords);
    }

    protected Integer calculate(List<String>queryKeywords, List<String> webAppPageKeywords){
        int relevance =0;
        for(String webAppPageKeyword:webAppPageKeywords){
            if(queryKeywords.contains(webAppPageKeyword)){
                relevance += (MAXIMUM_WEIGHT - queryKeywords.indexOf(webAppPageKeyword)) * (MAXIMUM_WEIGHT - webAppPageKeywords.indexOf(webAppPageKeyword));
            }
        }
        return relevance;
    }
}
