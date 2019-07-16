package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_mtcevent_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "定点消息推送(支付宝)")
    public void market_mtcevent_index_true() {

        setUrl("market.mtcevent.index.uri");
        process(false,false);

    }
}
