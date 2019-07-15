package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class OrderOrderdetail extends FybInterfaceTest {

    @Test(description = "订单详情")
    public void orderOrderdetail() {
        setUrl("order.orderdetail.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
    }
}
