package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class OrderDeliverymessage extends FybInterfaceTest {

    @Test(description = "物流信息")
    public void orderDeliverymessage() {
        setUrl("order.deliverymessage.uri");
        param = "orderId=" + SqlDetail.getParamValue("orderId");
        process(false,false);
    }
}
