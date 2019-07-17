package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivityGetactivityinfo extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "活动详情")
    public void activityGetactivityinfo() {
        setUrl("activityGetactivityinfo.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
    }
}
