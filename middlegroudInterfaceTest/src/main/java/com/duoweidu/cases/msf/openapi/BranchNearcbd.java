package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class BranchNearcbd extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "地理位置")
    public void branchNearcbd() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.BRANCH_NEARCBD);
        param = "lng=" + TestSql.getValue("lng",4) +
                "&lat=" + TestSql.getValue("lat",4) +
                "&zone_id=" + TestSql.getValue("zone_id",4);
        process(true,false);
    }
}
