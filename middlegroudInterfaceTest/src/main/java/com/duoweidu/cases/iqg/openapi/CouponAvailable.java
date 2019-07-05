package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class CouponAvailable extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "券列表")
    public void couponAvailableTrue () {
        setUrl("coupon.available.uri");
        process(true,false);
    }
}
