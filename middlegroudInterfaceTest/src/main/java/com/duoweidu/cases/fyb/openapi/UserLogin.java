package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogin extends FybInterfaceTest {

    @Test(groups = "loginTrue",description = "登录")
    public void userLogin() {
        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", "081KbIdQ0Iy1C42A4yaQ020OdQ0KbIdo"));
        process(list,false,false);
    }
}
