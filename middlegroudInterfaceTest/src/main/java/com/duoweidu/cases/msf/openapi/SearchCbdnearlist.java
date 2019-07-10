package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class SearchCbdnearlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "附近美食-商圈搜索（按地址位置）")
    public void searchCbdnearlist() {
        setUrl("search.cbdnearlist.uri");
        process(true,false);
    }
}
