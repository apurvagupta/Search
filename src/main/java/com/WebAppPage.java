package com;

import java.util.ArrayList;
import java.util.List;

import static com.SearchEngine.MAXIMUM_WEIGHT;

/**
 * Created by apurvagu on 16/12/16.
 */
public class WebAppPage extends Relevance {

    private List keywords;
    private Integer pageNumber;
    private Integer relevance;

    public WebAppPage(List keywords, Integer pageNumber) {
        this.keywords = validateKeyWordSize(keywords);
        this.pageNumber = pageNumber;
    }

    private List validateKeyWordSize(List keywords) {
        return keywords.size()> MAXIMUM_WEIGHT? keywords.subList(0,MAXIMUM_WEIGHT): keywords;
    }

    public Integer queryRelevance(Query query){
        relevance = calculateRelevance(toLower(query.getKeyWords()), toLower(keywords));
        return relevance;
    }


    public String getPageNumber() {
        return "P"+ pageNumber;
    }

    public List toLower(List<String> keywords){
        List keys = new ArrayList();
        for(String key: keywords){
            keys.add(key.toLowerCase());
        }
        return keys;
    }
}
