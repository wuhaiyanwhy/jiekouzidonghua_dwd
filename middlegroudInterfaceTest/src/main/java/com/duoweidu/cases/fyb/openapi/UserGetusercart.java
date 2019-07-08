package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserGetusercart extends FybInterfaceTest {

    @Test(dependsOnGroups = "userAddskutocart",description = "获取用户购物车",groups = "userGetusercart")
    public void userGetusercart() {
        setUrl("user.getusercart.uri");
        process(true,true);
    }
}
