package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class UserLogin extends IqgInterfaceTest {

    @Test(groups = "loginTrue",description = "成功登录")
    public void user_login_true() {
        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", SqlDetail.getParamValue(0, "mobile")));
        list.add(new BasicNameValuePair("password", SqlDetail.getParamValue(0, "password")));
        process(list, true, false);
        //cookie信息存为默认值
        GeneralConfig.store = GeneralConfig.defaultHttpClient.getCookieStore();
    }
}
