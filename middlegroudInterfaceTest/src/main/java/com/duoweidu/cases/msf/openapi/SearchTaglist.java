package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTaglist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "搜索标签")
    public void searchTaglist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.SEARCH_TAGSLIST);
        param = "name=" + TestSql.getValue("tagName",4);
        process(true,true);
    }
}
