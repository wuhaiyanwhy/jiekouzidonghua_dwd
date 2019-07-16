package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class user_getcouponinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户领用的优惠券")
    public void user_getcouponinfo_true() {
        setUrl("user.getcouponinfo.uri");
        param = "rewardCode=2018090";
        process(false,false);
    }
}
