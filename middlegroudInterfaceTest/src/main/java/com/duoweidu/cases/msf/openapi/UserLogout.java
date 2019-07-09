package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserLogout extends OpenapiInterfaceTest {

    @AfterClass
    @Test(description = "退出登录")
    public void userLogout() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_LOGOUT);
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}

