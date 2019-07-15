package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class finance_statementorder_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单明细")
    public void finance_statementorder_true() {

        setUrl("finance.statementorder.uri");
        process(false,false);

    }
}
