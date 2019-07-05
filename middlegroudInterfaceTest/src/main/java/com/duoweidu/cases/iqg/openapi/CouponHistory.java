package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class CouponHistory extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "券历史")
    public void couponHistoryTrue() {
        setUrl("coupon.history.uri");
        process(true,false);
    }
}
