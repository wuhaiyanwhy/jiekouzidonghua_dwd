package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_resetpwd_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "重置密码")
    public void user_resetpwd_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_RESETPWD);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile","15921932921"));
        list.add(new BasicNameValuePair("password","123456"));
        list.add(new BasicNameValuePair("verifyCode","123456"));
        list.add(new BasicNameValuePair("type","3"));
        process(list,false,false);
    }
}
