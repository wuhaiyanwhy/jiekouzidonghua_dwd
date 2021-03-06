package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class CouponActivitydetail extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券详情")
    public void coupon_activitydetail_true() {
        setUrl("coupon.activitydetail.uri");
        param = "branchId=" + SqlDetail.getInstance().getParamValue("branchId") +
                "&id=" + SqlDetail.getInstance().getParamValue(2, "oneCouponID");
        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
