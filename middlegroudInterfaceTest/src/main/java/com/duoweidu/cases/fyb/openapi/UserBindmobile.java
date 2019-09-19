package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 无法一只获取验证码，暂时无需详细断言
 */
public class UserBindmobile extends FybInterfaceTest {

    @Test(description = "绑定手机号")
    public void userBindmobile() {
        setUrl("user.bindmobile.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile","15921932921"));
        list.add(new BasicNameValuePair("verifyCode","123456"));
        list.add(new BasicNameValuePair("type","3"));
        process(list,false,false);
    }
}
