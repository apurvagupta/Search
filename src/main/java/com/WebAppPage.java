package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.SearchEngine.MAXIMUM_WEIGHT;

/**
 * Created by apurvagu on 16/12/16.
 */
public class WebAppPage {

    private List keywords;
    private Integer pageNumber;
    private List<WebAppPage> children = new ArrayList<WebAppPage>();

    public WebAppPage(List keywords, Integer pageNumber) {
        this.keywords = validateKeyWordSize(keywords);
        this.pageNumber = pageNumber;
    }

    private List validateKeyWordSize(List keywords) {
        return keywords.size() > MAXIMUM_WEIGHT ? keywords.subList(0, MAXIMUM_WEIGHT) : keywords;
    }

    public RelevanceData queryRelevance(Query query) {
        Integer parentRelevance = Relevance.calculateRelevance(toLower(query.getKeyWords()), toLower(keywords));
        Double includeChildRelevance = 0.0;
        for (WebAppPage child : children) {
            Integer childrenRelevance = Relevance.calculateRelevance(toLower(query.getKeyWords()), toLower(child.keywords));
            includeChildRelevance += childrenRelevance * 0.1;
        }
        return new RelevanceData(parentRelevance + includeChildRelevance);
    }


    public String getPageNumber() {
        return "P" + pageNumber;
    }

    public List toLower(List<String> keywords) {
        List keys = new ArrayList();
        for (String key : keywords) {
            keys.add(key.toLowerCase());
        }
        return keys;
    }

    public void addChildren(WebAppPage... children) {
        Collections.addAll(this.children, children);
    }
}
