package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.UserLoginData;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class user_login_test extends HsqInterfaceTest {

    private UserLoginData model;

    @Test(groups = "loginTrue",description = "用户成功登陆接口")
    public void login_true() {
        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", SqlDetail.getInstance().getParamValue(0,"mobile")));
        list.add(new BasicNameValuePair("password",SqlDetail.getInstance().getParamValue(0, "password")));
        list.add(new BasicNameValuePair("type", "1"));
        process(list,true,false);
        //cookie信息存为默认值
        GeneralConfig.store = CallbackInterface.defaultHttpClient.getCookieStore();
        System.out.println(GeneralConfig.store);
        model = sparseJson(UserLoginData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("username", model.username);
        detailAssertTest("avatar", model.avatar);
        detailAssertTest("mobile", model.mobile);
        detailAssertTest("birthday", model.birthday);
        detailAssertTest("sex", String.valueOf(model.sex));
        detailAssertTest(1, "enabled", model.enabled);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("saved_money_total", model.saved_money_total);
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("wechat_union_id", model.wechat_union_id);
        detailAssertTest("last_login", model.last_login);
        detailAssertTest("register_type", model.register_type);
        detailAssertTest("invite_code", model.invite_code);
        detailAssertTest("token", model.token);
    }

}
