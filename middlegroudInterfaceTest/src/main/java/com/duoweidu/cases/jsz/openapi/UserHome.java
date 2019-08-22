package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.model.jsz.UserHomeData;
import org.testng.annotations.Test;

public class UserHome extends JszInterfaceTest {

    private UserHomeData model;

    @Test(description = "用户个人中心")
    public void userHome() {
        setUrl("user.home.uri");
        process(true, false);
        model = sparseJson(UserHomeData.class);
        detailAssert();
    }

    private void detailAssert(){
        detailAssertTest("commission_accum_amount",model.commission_accum_amount);
//        detailAssertTest("coming_soon_amount",model.coming_soon_amount);
        for ( int i = 0; i<model.order_cnt.size(); i++){
            detailAssertTest("unpaid",model.order_cnt.get(i).unpaid);
//            detailAssertTest("unused",model.order_cnt.get(i).unused);
        }
        for ( int i = 0; i<model.user_info.size(); i++){
            detailAssertTest("id",model.user_info.get(i).id);
            detailAssertTest("dwd_uid",model.user_info.get(i).dwd_uid);
//            detailAssertTest("dwd_oauth_id",model.user_info.get(i).dwd_oauth_id);
            detailAssertTest("nickname",model.user_info.get(i).nickname);
            detailAssertTest("15261875682","mobile",model.user_info.get(i).mobile);
            detailAssertTest("avatar",model.user_info.get(i).avatar);
//            detailAssertTest("salt",model.user_info.get(i).salt);
            detailAssertTest("share_code",model.user_info.get(i).share_code);
            detailAssertTest(1,"member_level",model.user_info.get(i).member_level);
            detailAssertTest("created_at",model.user_info.get(i).created_at);
            detailAssertTest("updated_at",model.user_info.get(i).updated_at);
            detailAssertTest(0,"step",model.user_info.get(i).step);
            detailAssertTest("id",model.user_info.get(i).id);
            detailAssertTest("openid",model.user_info.get(i).openid);
//            detailAssertTest("oauth_appid",model.user_info.get(i).oauth_appid);
        }
    }
}
