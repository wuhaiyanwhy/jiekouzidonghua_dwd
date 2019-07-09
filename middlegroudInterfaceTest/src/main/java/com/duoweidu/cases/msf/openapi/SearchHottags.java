package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchHottags extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "热门标签")
    public void searchHottags() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.SEARCH_HOTTAGS);
        param = "zone_id=" + TestSql.getValue("zone_id",4);
        process(true,true);
    }
}
