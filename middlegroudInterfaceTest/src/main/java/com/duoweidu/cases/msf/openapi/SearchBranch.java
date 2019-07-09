package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchBranch extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "地址搜索")
    public void searchBranch() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.SEARCH_BRANCH);
        param = "lng=" + TestSql.getValue("lng",4) +
                "&lat=" + TestSql.getValue("lat",4);
        process(true,false);
    }
}
