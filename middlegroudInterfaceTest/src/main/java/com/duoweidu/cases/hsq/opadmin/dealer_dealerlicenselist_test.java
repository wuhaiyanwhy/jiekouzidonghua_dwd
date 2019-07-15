package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class dealer_dealerlicenselist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "门店资质审核列表")
    public void dealer_dealerlicenselist_true() {

        setUrl("dealer.dealerlicenselist.uri");
        process(false,false);

    }
}
