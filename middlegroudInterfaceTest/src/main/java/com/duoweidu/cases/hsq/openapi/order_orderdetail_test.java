package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class order_orderdetail_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单详情（拼团）")
    public void order_orderdetail_pintuanTrue() {
        setUrl("order.orderdetail.uri");
        param = "orderId=" + SqlDetail.getParamValue("orderId");
        process(true,false);
    }
}

