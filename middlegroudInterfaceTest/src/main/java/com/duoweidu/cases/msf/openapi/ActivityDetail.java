package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivityDetail extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动详情")
    public void activityDetail() {
        setUrl("activity.detail.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
    }
}
