package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class market_newskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="今日新品")
    public void market_newskulist_true() {
        setUrl("market.newskulist.uri");
        process(true,true);
    }
}
