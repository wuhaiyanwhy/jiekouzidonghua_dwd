package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class OrderTypeRefund extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款订单")
    public void order_type_refund_true() {
        setUrl("order.type.refund.uri");
        process(false,false);
        generalAssertTest(false, true);
    }
}
