package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.UserLoginData;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogin extends MsfInterfaceTest {

    private UserLoginData model;


    @Test(groups = "loginTrue",description = "用户成功登录接口")
    public void userLogin() {

        setUrl("user.login.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("login_type","5"));
        list.add(new BasicNameValuePair("remember","1"));
        list.add(new BasicNameValuePair("mobile", SqlDetail.getInstance().getParamValue(0, "mobile")));
        list.add(new BasicNameValuePair("password",SqlDetail.getInstance().getParamValue(0, "password")));

        process(list,true,false);
        //cookie信息储存未默认值
        GeneralConfig.store = CallbackInterface.defaultHttpClient.getCookieStore();
        System.out.println("cookie信息：" + GeneralConfig.store);
        model = sparseJson(UserLoginData.class);
        detailAssert();
        MsfConfig.token = model.token;
        MsfConfig.userId = model.id;
    }

    private void detailAssert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("mobile", model.mobile);
        assertNotEmpty("token", model.token);
        assertNotEmpty("avatar", model.avatar);
        assertNotEmpty("nickname", model.nickname);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("last_login", model.last_login);
        assertNotEmpty("is_register", model.is_register);
        assertNotEmpty("need_bind_mobile", model.need_bind_mobile);
        assertNotNull("group_id", model.group_id);
        assertNotNull("level_id", model.level_id);
        assertNotNull("invite_user_id", model.invite_user_id);
        assertNotNull("oauth_info", model.oauth_info);
        assertNotEmpty("register_time", model.register_time);
        assertNotEmpty("is_profile_complete", model.is_profile_complete);
        assertNotEmpty("permissions.video", model.permissions.video);
    }
}
