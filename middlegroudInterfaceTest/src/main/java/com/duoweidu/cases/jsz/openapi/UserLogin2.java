package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.model.jsz.UserHomeData;
import com.duoweidu.model.jsz.UserLogin2Data;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogin2 extends JszInterfaceTest {

    private UserLogin2Data model;

    @Test(description = "根据token获取用户信息")
    public void userLogin2() {
        setUrl("user.login2.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, false, false);
        model = sparseJson(UserLogin2Data.class);
        detailAssert();
    }

    private void detailAssert() {
            detailAssertTest("id", model.id);
            detailAssertTest("dwd_uid", model.dwd_uid);
//            detailAssertTest("dwd_oauth_id", model.dwd_oauth_id);
            detailAssertTest("nickname", model.nickname);
            detailAssertTest("15261875682", "mobile",model.mobile);
            detailAssertTest("avatar", model.avatar);
            detailAssertTest("salt", model.salt);
            detailAssertTest("share_code", model.share_code);
            detailAssertTest(1, "member_level", model.member_level);
            detailAssertTest("created_at", model.created_at);
            detailAssertTest("updated_at", model.updated_at);
            detailAssertTest(0, "step",model.step);
            detailAssertTest("id", model.id);
            detailAssertTest("openid", model.openid);
//            detailAssertTest("oauth_appid", model.oauth_appid);
    }
}

