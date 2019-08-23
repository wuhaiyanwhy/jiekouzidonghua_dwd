package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

/**
 * 暂时无售后订单，暂时无需详细断言
 */
public class OrderUserserviceorders extends FybInterfaceTest {

    @Test(description ="获取用户售后订单")
    public void orderUserserviceorders() {
        setUrl("order.userserviceorders.uri");
        process(true,false);
    }
}
