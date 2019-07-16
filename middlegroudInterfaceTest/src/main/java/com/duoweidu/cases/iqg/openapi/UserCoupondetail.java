package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class UserCoupondetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券订单详情")
    public void user_coupondetail_true() {
        setUrl("user.coupondetail.uri");
        param = "platform2=ios&branchId=" + SqlDetail.getInstance().getParamValue("branchId") +
                "&id=" + SqlDetail.getInstance().getParamValue("oneCouponOrderID") +
                "&zone_id=" + SqlDetail.getInstance().getParamValue(0, "zone_id");
        process(true,false);
    }
}
