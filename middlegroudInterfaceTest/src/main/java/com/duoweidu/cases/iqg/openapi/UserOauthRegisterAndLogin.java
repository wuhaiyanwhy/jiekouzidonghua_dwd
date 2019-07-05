package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserOauthRegisterAndLogin extends IqgInterfaceTest {

    @Test(groups = "UserOauthRegisterAndLogin",description = "绑定微信")
    public void user_oauth_register_and_login_true() {
        setUrl("user.oauth.register_and_login.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
