package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.SearchHottagsData;
import org.testng.annotations.Test;

public class SearchHottags extends MsfInterfaceTest {

    private SearchHottagsData model;

    @Test(dependsOnGroups = "loginTrue",description = "热门标签")
    public void searchHottags() {
        setUrl("search.hottags.uri");
        process(true,true);
        model = sparseJson(SearchHottagsData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);

        }
    }
}
