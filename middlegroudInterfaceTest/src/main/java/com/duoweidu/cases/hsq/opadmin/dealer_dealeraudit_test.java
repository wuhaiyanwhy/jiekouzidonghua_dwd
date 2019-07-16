package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class dealer_dealeraudit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店资质审核")
    public void dealer_dealeraudit_true() {

        setUrl("dealer.dealeraudit.uri");
        process(false,false);

    }
}
