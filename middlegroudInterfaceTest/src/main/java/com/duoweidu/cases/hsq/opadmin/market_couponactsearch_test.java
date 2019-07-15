package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_couponactsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "注册领券活动搜索")
    public void market_couponactsearch_true() {
        setUrl("market.couponactsearch.uri");
        process(false,false);

    }
}
