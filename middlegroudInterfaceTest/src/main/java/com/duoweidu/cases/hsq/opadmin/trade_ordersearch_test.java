package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class trade_ordersearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单查询搜索")
    public void trade_ordersearch_true() {
        setUrl("trade.ordersearch.uri");
        process();
    }
}
