package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class order_userserviceorders_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户售后订单")
    public void order_userserviceorders_true() {
        setUrl("order.userserviceorders.uri");
        process(true,false);
    }

}
