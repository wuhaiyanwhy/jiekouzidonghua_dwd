package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class trade_payment_abnormallist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "异常支付审核列表不正常的")
    public void trade_payment_abnormallist_true() {

        setUrl("trade.payment.abnormallist.uri");
        process();
    }

}
