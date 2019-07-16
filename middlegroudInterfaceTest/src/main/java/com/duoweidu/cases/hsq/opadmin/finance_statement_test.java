package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class finance_statement_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "财务对账")
    public void finance_statement_true() {

        setUrl("finance.statement.uri");
        process(false,false);

    }
}
