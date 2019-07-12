package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class CouponorderBeforecreate extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "一元券支付页面")
    public void couponorder_beforecreate_true() {
        //修改用户订单数据，使其可以下单
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            SqlDetail.iqgUptadeOneCouponOrder();
        }
        setUrl("couponorder.beforecreate.uri");
        param = "branchId=" + SqlDetail.getParamValue("branchId") +
                "&coupActivityId=" + SqlDetail.getParamValue(2, "oneCouponID") +
                "&zone_id=" + SqlDetail.getParamValue(0, "zone_id");
        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
