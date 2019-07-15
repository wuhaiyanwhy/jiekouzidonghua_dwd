package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_firstorderdiscount_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首单专享优惠")
    public void market_firstorderdiscount_true() {
        setUrl("market.firstorderdiscount.uri");
        process(false,false);

    }

}
