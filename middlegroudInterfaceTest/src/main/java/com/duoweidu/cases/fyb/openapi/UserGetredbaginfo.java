package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserGetredbaginfo extends FybInterfaceTest {

    @Test(description = "获取用户未激活红包余额")
    public void userGetredbaginfo() {
        setUrl("user.getredbaginfo.uri");
        process(true,false);
    }
}
