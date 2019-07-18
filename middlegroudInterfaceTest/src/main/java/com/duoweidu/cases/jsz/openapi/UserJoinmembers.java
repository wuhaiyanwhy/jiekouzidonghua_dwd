package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class UserJoinmembers extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "加入分销会员")
    public void userJoinmembers() {
        setUrl("user.joinmembers.uri");
        process(false, false);
    }
}
