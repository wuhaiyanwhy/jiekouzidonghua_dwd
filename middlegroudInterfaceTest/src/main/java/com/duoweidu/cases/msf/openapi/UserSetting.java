package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserSettingData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserSetting extends MsfInterfaceTest {

    private UserSettingData model;

    @Test(dependsOnGroups = "loginTrue",description = "账户设置")
    public void userSetting() {
        setUrl("user.setting.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(UserSettingData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("avatar", model.avatar);
        assertNotNull("quality_user", model.quality_user);
        assertNotEmpty("nickname", model.nickname);
        assertNotEmpty("nickname_revisable", model.nickname_revisable);
        assertNotEmpty("gender", model.gender);
        assertNotEmpty("birthday", model.birthday);
        assertNotEmpty("mobile", model.mobile);
        assertNotNull("introduction", model.introduction);
        assertNotEmpty("password_setted", model.password_setted);
        assertNotEmpty("terms_of_service", model.terms_of_service);
        assertNotEmpty("about_us", model.about_us);
        assertNotEmpty("profile_status.nickname", model.profile_status.nickname);
        assertNotEmpty("profile_status.avatar", model.profile_status.avatar);
        assertNotEmpty("profile_status.gender", model.profile_status.gender);
        assertNotEmpty("profile_status.birthday", model.profile_status.birthday);
        assertNotEmpty("profile_status.introduction", model.profile_status.introduction);


    }
}
