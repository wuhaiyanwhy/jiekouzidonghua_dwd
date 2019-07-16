package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class trade_refundlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单申诉")
    public void trade_refundlist_true() {
        setUrl("trade.refundlist.uri");
        process();
    }
}
