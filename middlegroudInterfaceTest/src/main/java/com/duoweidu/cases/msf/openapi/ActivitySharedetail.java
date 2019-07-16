package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ActivitySharedetail extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动分享详情接口")
    public void activitySharedetail() {
        setUrl("activity.sharedetail.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
    }
}
