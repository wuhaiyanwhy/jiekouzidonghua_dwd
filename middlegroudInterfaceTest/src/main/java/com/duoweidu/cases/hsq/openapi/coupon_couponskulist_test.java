package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 单品优惠券暂时无sku,暂时无需通用断言
 */
public class coupon_couponskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取单品优惠券sku列表")
    public void coupon_couponskulist_true() {
        setUrl("coupon.couponskulist.uri");
        param = "couponId=2969";
        process(true,false);
    }

}
