package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class market_pinactivitiessearch_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "拼团搜索")
    public void market_pinactivitiessearch_true() {
        setUrl("market.pinactivitiessearch.uri");
        param = "q=饼干";
        process(true,true);
    }
}
