package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_actcodesearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动码搜索")
    public void market_actcodesearch_true() {
        setUrl("market.actcodesearch.uri");
        process(false,false);

    }
}
