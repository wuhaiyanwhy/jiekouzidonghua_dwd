package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class OrderRefund extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "申请退款页面接口")
    public void orderRefund() {
        setUrl("order.refund.uri");
        param = "order_id=" + SqlDetail.getParamValue("order_id");
        process(false,false);
    }
}
