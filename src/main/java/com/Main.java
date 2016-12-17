package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by apurvagu on 17/12/16.
 */
public class Main {

    public static void main(String args[]){
        List pageKeywords1 = Arrays.asList("Ford", "Car", "Review");
        List pageKeywords2 = Arrays.asList("Review", "Car");
        List pageKeywords3 = Arrays.asList("Review", "Ford");
        List pageKeywords4 = Arrays.asList("Toyota", "Car");
        List pageKeywords5 = Arrays.asList("Honda", "Car");
        List pageKeywords6 = Arrays.asList("Car");

        List queryKeywords1 = Arrays.asList("Ford");
        List queryKeywords2 = Arrays.asList("Car");
        List queryKeywords3 = Arrays.asList("Review");
        List queryKeywords4 = Arrays.asList("Ford", "Review");
        List queryKeywords5 = Arrays.asList("Ford", "Car");
        List queryKeywords6 = Arrays.asList("cooking", "French");

        Query q1 = new Query(queryKeywords1, 1);
        Query q2 = new Query(queryKeywords2, 2);
        Query q3 = new Query(queryKeywords3, 3);
        Query q4 = new Query(queryKeywords4, 4);
        Query q5 = new Query(queryKeywords5, 5);
        Query q6 = new Query(queryKeywords6, 6);
        Queries queries = new Queries(q1, q2, q3, q4, q5, q6);

        WebAppPage p1 = new WebAppPage(pageKeywords1, 1);
        WebAppPage p2 = new WebAppPage(pageKeywords2, 2);
        WebAppPage p3 = new WebAppPage(pageKeywords3, 3);
        WebAppPage p4 = new WebAppPage(pageKeywords4, 4);
        WebAppPage p5 = new WebAppPage(pageKeywords5, 5);
        WebAppPage p6 = new WebAppPage(pageKeywords6, 6);
        WebAppPages webPages = new WebAppPages(p1, p2, p3, p4, p5, p6);

        SearchEngine searchEngine = new SearchEngine(queries, webPages);

        Map resultPageNumbers = searchEngine.search();

        System.out.println(resultPageNumbers);
    }
}
