package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一直注册，暂时无需详细断言
 */
public class user_register_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "注册")
    public void user_register_true() {
        setUrl("user.register.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile","15921932921"));
        list.add(new BasicNameValuePair("password","123456"));
        list.add(new BasicNameValuePair("verifyCode","123456"));
        list.add(new BasicNameValuePair("type","1"));
        process(list,false,false);
    }
}
