package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class OrderPayment extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付页面接口")
    public void orderPayment() {
        setUrl("order.payment.uri");
        param = "activity_id=" + SqlDetail.getParamValue(2, "pay_activity_id");
        process(false, false);
        //线上无法下单
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }
    }
}
