package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class SearchTaglist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "搜索标签")
    public void searchTaglist() {
        setUrl("search.taglist.uri");
        param = "name=" + SqlDetail.getParamValue(0, "tagName");
        process(true,true);
    }
}
