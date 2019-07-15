package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class trade_paymentabnormalsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "异常支付审核搜索")
    public void trade_paymentabnormalsearch_true() throws IOException {
        setUrl("trade.paymentabnormalsearch.uri");
        process();
    }
}
