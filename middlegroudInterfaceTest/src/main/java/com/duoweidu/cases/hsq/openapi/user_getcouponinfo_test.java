package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class user_getcouponinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户领用的优惠券")
    public void user_getcouponinfo_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_GETCOUPONINFO);
        param = "rewardCode=2018090";
        process(false,false);
    }
}
