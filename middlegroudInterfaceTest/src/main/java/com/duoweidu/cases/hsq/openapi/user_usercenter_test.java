package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_usercenter_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户中心")
    public void user_usercenter_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_USERCENTER);
        process(true,false);
    }
}
