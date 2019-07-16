package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class user_userinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户信息")
    public void user_userinfo_true() {
        setUrl("user.userinfo.uri");
        process(true,false);
    }


}
