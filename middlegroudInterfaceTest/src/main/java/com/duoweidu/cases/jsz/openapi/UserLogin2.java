package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogin2 extends JszInterfaceTest {

    @Test(description = "根据token获取用户信息")
    public void userLogin2() {
        setUrl("user.login2.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, false, false);
    }
}

