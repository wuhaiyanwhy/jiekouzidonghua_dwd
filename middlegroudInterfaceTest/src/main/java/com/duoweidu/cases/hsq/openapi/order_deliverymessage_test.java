package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class order_deliverymessage_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "查看物流")
    public void order_deliverymessage_true() {
        setUrl("order.deliverymessage.uri");
        param = "orderId=" + SqlDetail.getParamValue("orderId");
        process(false,false);
    }

}
