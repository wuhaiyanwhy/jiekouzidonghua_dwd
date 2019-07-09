package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class BranchDetail extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店详情")
    public void branchDetail() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.BRANCH_DETAIL);
        param = "id=" + TestSql.getValue("branch_id") +
                "&lng=" + TestSql.getValue("lng",4) +
                "&lat=" + TestSql.getValue("lat",4);
        process(true,false);
    }
}
