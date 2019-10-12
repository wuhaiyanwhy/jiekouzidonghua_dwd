package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class trade_nonuserapplyrefundlist_test extends HsqOpadminInterfaceTest {

    @Override
    protected long limitTime() {
        return 5000;
    }

    @Test(dependsOnGroups = "loginTrue",description = "未申诉订单")
    public void trade_nonuserapplyrefundlist_true() {
        setUrl("trade.nonuserapplyrefundlist.uri");
        process();
    }
}
