package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;


public class user_coupleactivitiedetail_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "分享详情")
    public void user_coupleactivitiedetail_true() {
        setUrl("user.coupleactivitiedetail.uri");
        param = "pinEventId=" + SqlDetail.getParamValue("pinEventId");
        process(true,false);
    }
}

