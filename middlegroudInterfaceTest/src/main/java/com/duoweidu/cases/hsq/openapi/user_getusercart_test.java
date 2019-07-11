package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_getusercart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户购物车")
    public void user_getusercart_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_GETUSERCART);
        process(true,false);
    }
}
