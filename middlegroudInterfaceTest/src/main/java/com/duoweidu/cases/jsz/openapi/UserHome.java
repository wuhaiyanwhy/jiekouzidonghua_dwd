package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class UserHome extends JszInterfaceTest {

    @Test(description = "用户个人中心")
    public void userHome() {
        setUrl("user.home.uri");
        process(true, false);
    }
}
