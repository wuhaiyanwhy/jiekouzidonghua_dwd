package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class SearchBranch extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "地址搜索")
    public void searchBranch() {
        setUrl("search.branch.uri");
        process(true,false);
    }
}
