package com;

import com.googlecode.totallylazy.Sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class SearchEngine {
    private String key;
    private WebPages webPages;

    public SearchEngine(String key, WebPages webPages) {
        this.key = key;
        this.webPages = webPages;
    }

    public List<String> search() {
        Sequence<LcmeWebPage> lcmeWebPages = webPages.keyExists(key);
        ArrayList<String> pageNumbers = new ArrayList<String>();
        for (LcmeWebPage lcmeWebPage: lcmeWebPages){

            pageNumbers.add(lcmeWebPage.getPageNumber());
        }
        return pageNumbers;

    }
}
