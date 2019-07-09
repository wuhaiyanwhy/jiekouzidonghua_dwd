package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserProfile extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人中心详情页")
    public void userProfile() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_PROFILE);
        param = "page_num=1&page_limit=20";
        process(true,false);
    }
}
