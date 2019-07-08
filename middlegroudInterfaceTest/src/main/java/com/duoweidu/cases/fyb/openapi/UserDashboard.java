package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserDashboard extends FybInterfaceTest {

    @Test(description = "用户中心")
    public void userDashboard() {
        setUrl("user.dashboard.uri");
        process(true,false);
    }
}
