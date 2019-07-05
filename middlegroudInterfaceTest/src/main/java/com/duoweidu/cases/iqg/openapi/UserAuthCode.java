package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAuthCode extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取验证码")
    public void user_auth_code_true() {
        setUrl("user.auth_code.uri");
        List<NameValuePair> list = new LinkedList<>();
//        BasicNameValuePair param1 = new BasicNameValuePair("mobile", OpenapiEnvironmentParam.getMobile());
//        BasicNameValuePair param2 = new BasicNameValuePair("type", "reset");
//        list.add(param1);
//        list.add(param2);
        process(list,false,false);
        //无法频繁的获取验证码，不验证返回数据
    }
}
