package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivityDetail extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动详情")
    public void activityDetail() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ACTIVITY_DETAIL);
        param = "activity_id=" + TestSql.getValue("activity_id");
        process(true,false);
    }
}
