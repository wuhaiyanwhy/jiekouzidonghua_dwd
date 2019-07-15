package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class finance_statementorderlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单明细列表")
    public void finance_statementorderlist_true() {

        setUrl("finance.statementorderlist.uri");
        process(false,false);

    }

}
