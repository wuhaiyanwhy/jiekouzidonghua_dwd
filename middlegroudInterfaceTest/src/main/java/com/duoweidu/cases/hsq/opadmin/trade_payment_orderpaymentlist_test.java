package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class trade_payment_orderpaymentlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "异常支付审核列表订单")
    public void trade_payment_orderpaymentlist_true() {
        setUrl("trade.payment.orderpaymentlist.uri");
        process();
    }
}
