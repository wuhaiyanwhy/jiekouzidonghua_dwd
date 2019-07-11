package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_couponlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户优惠券(未使用)")
    public void user_couponlist_weishiyongTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_COUPONLIST);
        param = "type=1";
        process(true,false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="获取用户优惠券(已过期)")
    public void user_couponlist_yiguoqiTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_COUPONLIST);
        param = "type=2";
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(已使用)")
    public void user_couponlist_yishiyongTrue() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_COUPONLIST);
        param = "type=3";
        process(true,true);
    }

}
