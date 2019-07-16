package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class user_getusercart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户购物车")
    public void user_getusercart_true() {
        setUrl("user.getusercart.uri");
        process(true,false);
    }
}
