package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class UserLogincallback extends JszInterfaceTest {

    @Test(description = "登录")
    public void userLogincallback() {
        setUrl("user.logincallback.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("oauth_appid", SqlDetail.getInstance().getParamValue(0,"oauth_appid")));
        process(list, false, false);
    }
}