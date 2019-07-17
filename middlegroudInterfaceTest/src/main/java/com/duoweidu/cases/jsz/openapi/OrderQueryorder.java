package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class OrderQueryorder extends JszInterfaceTest {

    @Test(dependsOnGroups = "OrderCreateorder",description = "支付结果同步查询")
    public void orderQueryorder() {
        setUrl("order.queryorder.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("id") +
                "&paymentId=" + JszConfig.payment_id ;
        process(true, false);
    }
}
