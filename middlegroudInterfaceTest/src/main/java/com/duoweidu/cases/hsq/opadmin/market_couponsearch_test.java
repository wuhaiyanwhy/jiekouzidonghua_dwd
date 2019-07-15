package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_couponsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商家优惠券搜索")
    public void market_couponsearch_true() {
        setUrl("market.couponsearch.uri");
        process(false,false);

    }

}
