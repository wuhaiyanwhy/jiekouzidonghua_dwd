package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserRegister2 extends JszInterfaceTest {

    @Test(dependsOnGroups = "UserLogincallback",description = "绑定手机号")
    public void userRegister2() {
        setUrl("user.register2.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);

    }

}
