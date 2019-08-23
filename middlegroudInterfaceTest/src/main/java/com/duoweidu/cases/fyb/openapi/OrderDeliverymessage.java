package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 暂无正确的物流信息，暂时无需通用断言
 */
public class OrderDeliverymessage extends FybInterfaceTest {

    @Test(description = "物流信息")
    public void orderDeliverymessage() {
        setUrl("order.deliverymessage.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(false,false);
    }
}
