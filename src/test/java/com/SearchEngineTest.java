package com;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class SearchEngineTest {

    @Test
    public void shouldNotReturnWebPagesWhenNoWebPageHasQueryString(){
        List keywords = Arrays.asList("Car", "Review", "Ford");
        String key = "nothing";

        LcmeWebPage lcmeWebPage = new LcmeWebPage(keywords, 1);
        WebPages webPages = new WebPages(lcmeWebPage);

        SearchEngine searchEngine = new SearchEngine(key, webPages);

        List resultPageNumbers = searchEngine.search();

        Assert.assertEquals(0,resultPageNumbers.size());
    }

    @Test
    public void shouldReturnWebPagesWhenWebPageHasQueryString(){
        List keywords = Arrays.asList("Car", "Review", "Ford");
        String key = "Car";

        LcmeWebPage lcmeWebPage = new LcmeWebPage(keywords, 1);
        WebPages webPages = new WebPages(lcmeWebPage);

        SearchEngine searchEngine = new SearchEngine(key, webPages);

        List resultPageNumbers = searchEngine.search();

        Assert.assertEquals("P1",resultPageNumbers.get(0));
    }

}
