package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


/**
 * 老购物车接口，暂时无需详细断言
 */
public class user_getusercart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户购物车")
    public void user_getusercart_true() {
        setUrl("user.getusercart.uri");
        process(true,false);
    }
}
