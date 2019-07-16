package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class coupon_couponskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取单品优惠券sku列表")
    public void coupon_couponskulist_true() {
        setUrl("coupon.couponskulist.uri");
        param = "couponId=2018098";
        process(true,false);
    }

}
