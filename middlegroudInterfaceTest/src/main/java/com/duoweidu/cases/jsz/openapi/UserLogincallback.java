package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;

public class UserLogincallback extends JszInterfaceTest {

    @Test(groups = "UserLogincallback",description = "登录")
    public void userLogincallback() {
        setUrl("user.logincallback.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("oauth_appid", "wx95f64a24631b6324"));
        process(list, false, false);
    }
}