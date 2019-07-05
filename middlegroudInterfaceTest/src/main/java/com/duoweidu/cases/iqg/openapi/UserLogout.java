package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class UserLogout extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退出登录")
    public void userLogoutTrue() {
        setUrl("user.logout.uri");
        process(false,false);
        generalAssertStatus();
    }
}
