package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class BranchCatlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店分类列表")
    public void branchCatlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.BRANCH_CATLIST);
        param = "zone_id=" + TestSql.getValue("zone_id",4);
        process(true,false);
    }
}
