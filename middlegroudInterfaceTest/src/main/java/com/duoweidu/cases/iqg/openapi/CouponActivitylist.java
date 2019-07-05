package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class CouponActivitylist extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券列表")
    public void coupon_activitylist_true() {
        setUrl("coupon.activitylist.uri");
        process(true,true);
    }

}
