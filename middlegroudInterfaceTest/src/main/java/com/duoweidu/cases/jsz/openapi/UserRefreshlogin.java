package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class UserRefreshlogin extends JszInterfaceTest {

    @Test(description = "获取token")
    public void UserRefreshlogin (){
        setUrl("user.refreshlogin.uri");
        process(true,false);
    }
}
