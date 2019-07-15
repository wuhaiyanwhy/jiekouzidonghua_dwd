package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_couponoprcdsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "优惠券使用明细搜索")
    public void market_couponoprcdsearch_true() {
        setUrl("market.couponoprcdsearch.uri");
        process(false,false);

    }
}
