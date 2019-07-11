package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_userinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户信息")
    public void user_userinfo_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_USERINFO);
        process(true,false);
    }


}
