package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogout extends MsfInterfaceTest {

    @AfterClass
    @Test(description = "退出登录")
    public void userLogout() {
        setUrl("user.logout.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}

