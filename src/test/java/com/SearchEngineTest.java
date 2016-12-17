package com;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by apurvagu on 16/12/16.
 */
public class SearchEngineTest {

    @Test
    public void shouldNotReturnWebPagesWhenNoWebPageHasQueryString(){
        List pageKeywords = Arrays.asList("Car", "Review", "Ford");
        List queryKeywords = Arrays.asList("Nothing");

        Queries queries = new Queries(new Query(queryKeywords, 1));
        WebAppPages webAppPages = new WebAppPages(new WebAppPage(pageKeywords, 1));
        SearchEngine searchEngine = new SearchEngine(queries, webAppPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");
        Assert.assertEquals(0, queryOneResult.size());
    }

    @Test
    public void shouldReturnWebPagesWhenWebPageHasQueryString(){
        List pageKeywords = Arrays.asList("Car", "Review", "Ford");
        List queryKeywords = Arrays.asList("Car");

        Queries queries = new Queries(new Query(queryKeywords, 1));
        WebAppPages webAppPages = new WebAppPages(new WebAppPage(pageKeywords, 1));

        SearchEngine searchEngine = new SearchEngine(queries, webAppPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");
        Assert.assertEquals(1, queryOneResult.size());
        Assert.assertEquals("P1", queryOneResult.get(0));
    }

    @Test
    public void shouldReturnMultipleWebPagesWhenWebPageHasQueryString() {
        List pageKeyWords = Arrays.asList("Car", "Review", "Ford");
        List pageKeywords1 = Arrays.asList("Review", "Ford", "Car");
        List queryKeywords = Arrays.asList("Car");

        WebAppPage lcmeWebPage = new WebAppPage(pageKeyWords, 1);
        WebAppPage lcmeWebPage1 = new WebAppPage(pageKeywords1, 2);
        WebAppPages webPages = new WebAppPages(lcmeWebPage, lcmeWebPage1);

        Queries queries = new Queries(new Query(queryKeywords, 1));
        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");
        Assert.assertEquals(2, queryOneResult.size());
        Assert.assertEquals("P1", queryOneResult.get(0));
        Assert.assertEquals("P2", queryOneResult.get(1));
    }

    @Test
    public void shouldReturnWebPagesWhenQueryStringsPresent() {
        List keywords = Arrays.asList("Car", "Review", "Ford");
        List keywords1 = Arrays.asList("Ford", "Car");
        List queryKeywords = Arrays.asList("Car", "Review");
        List queryKeywords1 = Arrays.asList("Review");

        Queries queries = new Queries(new Query(queryKeywords, 1),new Query(queryKeywords1, 2));
        WebAppPage lcmeWebPage = new WebAppPage(keywords, 1);
        WebAppPage lcmeWebPage1 = new WebAppPage(keywords1, 2);
        WebAppPages webPages = new WebAppPages(lcmeWebPage, lcmeWebPage1);

        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");
        List queryTwoResult = (List) resultPageNumbers.get("Q2");


        Assert.assertEquals(2, queryOneResult.size());
        Assert.assertEquals("P1", queryOneResult.get(0));
        Assert.assertEquals("P2", queryOneResult.get(1));

        Assert.assertEquals(1, queryTwoResult.size());
        Assert.assertEquals("P1", queryTwoResult.get(0));

    }

    @Test
    public void shouldReturnWebPagesWhenQueryStringsPresentBasedOnRelevance() {
        List pageKeywords = Arrays.asList("Car", "Ford");
        List pageKeywords1 = Arrays.asList("Ford", "Car", "Review");

        List queryKeywords = Arrays.asList("Car", "Review");
        List queryKeywords1 = Arrays.asList("Review");

        Query q1 = new Query(queryKeywords, 1);
        Query q2 = new Query(queryKeywords1, 2);
        Queries queries = new Queries(q1, q2);

        WebAppPage p1 = new WebAppPage(pageKeywords, 1);
        WebAppPage p2 = new WebAppPage(pageKeywords1, 2);
        WebAppPages webPages = new WebAppPages(p1, p2);

        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");
        List queryTwoResult = (List) resultPageNumbers.get("Q2");


        Assert.assertEquals(2, queryOneResult.size());
        Assert.assertEquals("P2", queryOneResult.get(0));
        Assert.assertEquals("P1", queryOneResult.get(1));

        Assert.assertEquals(1, queryTwoResult.size());
        Assert.assertEquals("P2", queryTwoResult.get(0));

    }

    @Test
    public void shouldReturnWebPagesWhenQueryStringsPresentBasedOnRelevanceSameRelevanceWebPagesShouldAppearInInsertionOrder() {
        List pageKeywords1 = Arrays.asList("Ford", "Car", "Review");
        List pageKeywords2 = Arrays.asList("Review", "Car");
        List pageKeywords3 = Arrays.asList("Review", "Ford");
        List pageKeywords4 = Arrays.asList("Toyota", "Car");
        List pageKeywords5 = Arrays.asList("Honda", "Car");
        List pageKeywords6 = Arrays.asList("Car");

        List queryKeywords1 = Arrays.asList("Car");

        Query q1 = new Query(queryKeywords1, 1);
        Queries queries = new Queries(q1);

        WebAppPage p1 = new WebAppPage(pageKeywords1, 1);
        WebAppPage p2 = new WebAppPage(pageKeywords2, 2);
        WebAppPage p3 = new WebAppPage(pageKeywords3, 3);
        WebAppPage p4 = new WebAppPage(pageKeywords4, 4);
        WebAppPage p5 = new WebAppPage(pageKeywords5, 5);
        WebAppPage p6 = new WebAppPage(pageKeywords6, 6);
        WebAppPages webPages = new WebAppPages(p1, p2, p3, p4, p5, p6);

        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");


        Assert.assertEquals(5, queryOneResult.size());
        Assert.assertEquals("P6", queryOneResult.get(0));
        Assert.assertEquals("P1", queryOneResult.get(1));
        Assert.assertEquals("P2", queryOneResult.get(2));
        Assert.assertEquals("P4", queryOneResult.get(3));
        Assert.assertEquals("P5", queryOneResult.get(4));


    }

    @Test
    public void shouldReturnOnly5MostRelevantWebPagesWhenMoreThan5HaveQuery() {
        List pageKeywords1 = Arrays.asList("Ford", "Car", "Review");
        List pageKeywords2 = Arrays.asList("Review", "Car");
        List pageKeywords3 = Arrays.asList("Review", "Ford");
        List pageKeywords4 = Arrays.asList("Toyota", "Car");
        List pageKeywords5 = Arrays.asList("Honda", "Car");
        List pageKeywords6 = Arrays.asList("Car");


        List queryKeywords1 = Arrays.asList("Ford", "Car");

        Query q1 = new Query(queryKeywords1, 1);
        Queries queries = new Queries(q1);

        WebAppPage p1 = new WebAppPage(pageKeywords1, 1);
        WebAppPage p2 = new WebAppPage(pageKeywords2, 2);
        WebAppPage p3 = new WebAppPage(pageKeywords3, 3);
        WebAppPage p4 = new WebAppPage(pageKeywords4, 4);
        WebAppPage p5 = new WebAppPage(pageKeywords5, 5);
        WebAppPage p6 = new WebAppPage(pageKeywords6, 6);
        WebAppPages webPages = new WebAppPages(p1, p2, p3, p4, p5, p6);

        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        List queryOneResult = (List) resultPageNumbers.get("Q1");


        Assert.assertEquals(5, queryOneResult.size());
        Assert.assertEquals("P1", queryOneResult.get(0));
        Assert.assertEquals("P3", queryOneResult.get(1));
        Assert.assertEquals("P6", queryOneResult.get(2));
        Assert.assertEquals("P2", queryOneResult.get(3));
        Assert.assertEquals("P4", queryOneResult.get(4));

    }


}
