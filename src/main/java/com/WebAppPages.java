package com;

import java.util.*;

/**
 * Created by apurvagu on 16/12/16.
 */
public class WebAppPages {
    private List<WebAppPage> webPages = new ArrayList<WebAppPage>();
    private  final int LIMIT_OF_RESULT = 5;
    private  final int START_OF_RESULT = 0;

    public WebAppPages(WebAppPage... webAppPage) {
        Collections.addAll(webPages, webAppPage);
    }


    public List getPageNumbersWith(Query query) {
        Map pageNumbersWithRelevance = new TreeMap();
        for (WebAppPage webAppPage : webPages){
            RelevanceData relevance = webAppPage.queryRelevance(query);
            if(!relevance.equals(new RelevanceData(0.0))) {
                pageNumbersWithRelevance.put(webAppPage.getPageNumber(), relevance);

            }
        }
        Map pageNumbersWithSortedRelevance = sortByRelevance(pageNumbersWithRelevance);
        ArrayList pageNumbers = new ArrayList(pageNumbersWithSortedRelevance.keySet());

        return limitResult(pageNumbers);
    }

    private List limitResult(ArrayList pageNumbers) {
        return pageNumbers.size()>LIMIT_OF_RESULT ? pageNumbers.subList(START_OF_RESULT, LIMIT_OF_RESULT):pageNumbers;
    }



    public Map sortByRelevance(Map pageNumbersWithRelevance )
    {
        List<Map.Entry<String, RelevanceData>> pageNumbersRelevanceEntry = new LinkedList(pageNumbersWithRelevance.entrySet() );
        Collections.sort( pageNumbersRelevanceEntry, new Comparator<Map.Entry<String, RelevanceData>>()
        {
            public int compare(Map.Entry<String, RelevanceData> o1, Map.Entry<String, RelevanceData> o2) {
                return ( o2.getValue() ).compareTo( o1.getValue());
            }
        });

        Map result = new LinkedHashMap ();
        for ( Map.Entry<String, RelevanceData> entry : pageNumbersRelevanceEntry)
        {
            result.put(entry.getKey(), entry.getValue() );
        }
        return result;
    }
}
