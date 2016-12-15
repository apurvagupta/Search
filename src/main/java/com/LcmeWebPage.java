package com;

import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class LcmeWebPage {

    private List keywords;
    private Integer pageNumber;

    public LcmeWebPage(List keywords, Integer pageNumber) {
        this.keywords = keywords;
        this.pageNumber = pageNumber;
    }

    public boolean keyExists(String key){
        return keywords.contains(key);
    }


    public String getPageNumber() {
        return "P"+ pageNumber;
    }
}
