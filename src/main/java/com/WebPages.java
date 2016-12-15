package com;

import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apurvagu on 16/12/16.
 */
public class WebPages {
    private List<LcmeWebPage> webPages = new ArrayList<LcmeWebPage>();

    public WebPages(LcmeWebPage lcmeWebPage) {
        webPages.add(lcmeWebPage);
    }

    public Sequence<LcmeWebPage> keyExists(final String key){
        return Sequences.sequence(webPages).filter(new Predicate<LcmeWebPage>() {
            public boolean matches(LcmeWebPage lcmeWebPage) {
                return lcmeWebPage.keyExists(key);
            }
        });
    }
}
