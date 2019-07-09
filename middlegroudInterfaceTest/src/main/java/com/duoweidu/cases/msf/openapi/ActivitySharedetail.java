package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivitySharedetail extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动分享详情接口")
    public void activitySharedetail() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ACTIVITY_SHAREDETAIL);
        param = "activity_id=" + TestSql.getValue("activity_id");
        process(true,false);
    }
}
