package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class user_usercenter_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "用户中心")
    public void user_usercenter_true() {
        setUrl("user.usercenter.uri");
        process(true,false);
    }
}
