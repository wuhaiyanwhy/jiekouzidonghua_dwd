package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_coupleactivitiedetail_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "分享详情")
    public void user_coupleactivitiedetail_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_COUPLEACTIVITIEDETAIL);
        param = "pinEventId=" + SqlDetail.getParamValue("pinEventId");
        process(true,false);
    }
}

