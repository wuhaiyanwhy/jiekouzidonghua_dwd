package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class SearchHottags extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "热门标签")
    public void searchHottags() {
        setUrl("search.hottags.uri");
        process(true,true);
    }
}
