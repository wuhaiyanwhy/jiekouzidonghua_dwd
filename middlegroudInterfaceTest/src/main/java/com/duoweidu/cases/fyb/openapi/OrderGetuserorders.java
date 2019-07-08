package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class OrderGetuserorders extends FybInterfaceTest {

    @Test(description = "用户订单列表")
    public void orderGetuserorders() {
        setUrl("order.getuserorders.uri");
        param = "type=0";
        process(true,true);
    }
}
