package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class OrderUserserviceorders extends FybInterfaceTest {

    @Test(description ="获取用户售后订单")
    public void orderUserserviceorders() {
        setUrl("order.userserviceorders.uri");
        process(true,false);
    }
}
