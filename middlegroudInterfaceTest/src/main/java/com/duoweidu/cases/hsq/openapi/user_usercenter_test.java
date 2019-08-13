package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserUsercenterData;
import org.testng.annotations.Test;


public class user_usercenter_test extends HsqInterfaceTest {

    private UserUsercenterData model;

    @Test(dependsOnGroups = "loginTrue",description = "用户中心")
    public void user_usercenter_true() {
        setUrl("user.usercenter.uri");
        process(true,false);
        model = sparseJson(UserUsercenterData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("favoritesProductCnt", model.favoritesProductCnt);
        detailAssertTest("favoritesMerchantCnt", model.favoritesMerchantCnt);
        detailAssertTest("toReceiptNum", model.toReceiptNum);
//        detailAssertTest("toCommentNum", model.toCommentNum);

        detailAssertTest("userInfo.username", model.userInfo.username);
        detailAssertTest("userInfo.avatar", model.userInfo.avatar);
        detailAssertTest("userInfo.mobile", model.userInfo.mobile);
        detailAssertTest("userInfo.birthday", model.userInfo.birthday);
        detailAssertTest("userInfo.sex", String.valueOf(model.userInfo.sex));
        detailAssertTest(1, "userInfo.enabled", model.userInfo.enabled);
        detailAssertTest("userInfo.created_at", model.userInfo.created_at);
        detailAssertTest("userInfo.wechat_mp_open_id", model.userInfo.wechat_mp_open_id);
        detailAssertTest("userInfo.user_id", model.userInfo.user_id);
        detailAssertTest("userInfo.inviteCode", model.userInfo.inviteCode);
        detailAssertTest("userInfo.wechat_union_id", model.userInfo.wechat_union_id);
        detailAssertTest("userInfo.register_type", model.userInfo.register_type);
        detailAssertTest("userInfo.token", model.userInfo.token);
        detailAssertTest("userInfo.is_test_user", model.userInfo.is_test_user);
        detailAssertTest("userInfo.authPhone", model.userInfo.authPhone);
        detailAssertTest("userInfo.userId", model.userInfo.userId);

        detailAssertTest("userinfo.username", model.userinfo.username);
        detailAssertTest("userinfo.avatar", model.userinfo.avatar);
        detailAssertTest("userinfo.mobile", model.userinfo.mobile);
        detailAssertTest("userinfo.birthday", model.userinfo.birthday);
        detailAssertTest("userinfo.sex", String.valueOf(model.userinfo.sex));
        detailAssertTest(1, "userinfo.enabled", model.userinfo.enabled);
        detailAssertTest("userinfo.created_at", model.userinfo.created_at);
        detailAssertTest("userinfo.wechat_mp_open_id", model.userinfo.wechat_mp_open_id);
        detailAssertTest("userinfo.user_id", model.userinfo.user_id);
        detailAssertTest("userinfo.inviteCode", model.userinfo.inviteCode);
        detailAssertTest("userinfo.wechat_union_id", model.userinfo.wechat_union_id);
        detailAssertTest("userinfo.register_type", model.userinfo.register_type);
        detailAssertTest("userinfo.token", model.userinfo.token);
        detailAssertTest("userinfo.is_test_user", model.userinfo.is_test_user);
        detailAssertTest("userinfo.authPhone", model.userinfo.authPhone);
        detailAssertTest("userinfo.userId", model.userinfo.userId);

        detailAssertTest("couponCnt", model.couponCnt);
//        detailAssertTest("pinOrderCnt", model.pinOrderCnt);
        detailAssertTest("talentLink", model.talentLink);
        detailAssertTest("light_member_expose_info.agreement_status", String.valueOf(model.light_member_expose_info.agreement_status));
        detailAssertTest("light_member_expose_info.desc", model.light_member_expose_info.desc);
        detailAssertTest("light_member_expose_info.image_url", model.light_member_expose_info.image_url);
//        detailAssertTest("recommend_source_id", model.recommend_source_id);
        detailAssertTest("transactionOrderCnt", model.transactionOrderCnt);

    }
}
