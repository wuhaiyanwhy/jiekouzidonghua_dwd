package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserUserinfoData;
import org.testng.annotations.Test;


public class user_userinfo_test extends HsqInterfaceTest {

    private UserUserinfoData model;

    @Test(dependsOnGroups = "loginTrue",description = "用户信息")
    public void user_userinfo_true() {
        setUrl("user.userinfo.uri");
        process(true,false);
        model = sparseJson(UserUserinfoData.class);
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
        detailAssertTest("wechat_mp_open_id", model.wechat_mp_open_id);
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("inviteCode", model.inviteCode);
        detailAssertTest("wechat_union_id", model.wechat_union_id);
        detailAssertTest("register_type", model.register_type);
        detailAssertTest("token", model.token);
        detailAssertTest("is_test_user", model.is_test_user);
        detailAssertTest("authPhone", model.authPhone);
        detailAssertTest("userId", model.userId);

    }


}
