package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserFollowlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关注/粉丝列表")
    public void userFollowlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_FOLLOWLIST);
        param = "type=1";
        process(true,true);
    }

}
