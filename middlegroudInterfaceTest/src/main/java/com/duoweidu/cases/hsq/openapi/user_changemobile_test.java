package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_changemobile_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "更换手机号")
    public void user_changemobile_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_CHANGEMOBILE);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile","15921932921"));
        list.add(new BasicNameValuePair("verifyCode","123456"));
        process(list,false,false);
    }
}
