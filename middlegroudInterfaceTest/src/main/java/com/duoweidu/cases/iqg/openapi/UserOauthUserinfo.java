package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserOauthUserinfo extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取微信用户信息")
    public void user_oauth_userinfo_true() {
        setUrl("user.oauth.userinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(0, "code")));
        process(list,false,false);
    }
}
