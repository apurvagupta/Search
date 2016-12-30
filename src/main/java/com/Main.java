package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by apurvagu on 17/12/16.
 */
public class Main {

    public static void main(String args[]){
        List pageKeywords1 = Arrays.asList("Ford", "Car");
        List pageKeywords2 = Arrays.asList("Review", "Car");
        List pageKeywords3 = Arrays.asList("Review", "Ford");
        List pageKeywords4 = Arrays.asList("Toyota", "Car");
        List pageKeywords5 = Arrays.asList("Car");

        List queryKeywords1 = Arrays.asList("Ford");
        List queryKeywords2 = Arrays.asList("Car");
        List queryKeywords3 = Arrays.asList("Review");
//        List queryKeywords4 = Arrays.asList("Ford", "Review");
//        List queryKeywords5 = Arrays.asList("Ford", "Car");
//        List queryKeywords6 = Arrays.asList("cooking", "French");

        Query q1 = new Query(queryKeywords1, 1);
        Query q2 = new Query(queryKeywords2, 2);
        Query q3 = new Query(queryKeywords3, 3);
//        Query q4 = new Query(queryKeywords4, 4);
//        Query q5 = new Query(queryKeywords5, 5);
//        Query q6 = new Query(queryKeywords6, 6);

        Queries queries = new Queries(q1, q2, q3);

        WebAppPage p1 = new WebAppPage(pageKeywords1, 1);
        WebAppPage childOfp1 = new WebAppPage(pageKeywords2, 1);
        WebAppPage child2Ofp1 = new WebAppPage(pageKeywords3, 1);
        p1.addChildren(childOfp1, child2Ofp1);

        WebAppPage p2 = new WebAppPage(pageKeywords4, 2);
        WebAppPage childOfp2 = new WebAppPage(pageKeywords5, 2);
        p2.addChildren(childOfp2);

        WebAppPages webPages = new WebAppPages(p1, p2);

        SearchEngine searchEngine = new SearchEngine(webPages);

        Map resultPageNumbers = searchEngine.search(queries);

        System.out.println(resultPageNumbers);
    }
}
