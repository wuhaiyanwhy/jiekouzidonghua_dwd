package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;


public class CouponActivitybranchlist extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券适用门店")
    public void couponActivitybranchlistTrue() {
        setUrl("coupon.activitybranchlist.uri");
        param = "id=" + SqlDetail.getParamValue("branchId");
        process(true,false);
    }
}
