package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class tradecenter_ordersuccess_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "积分订单成功页")
    public void tradecenter_ordersuccess_true() {
        setUrl("tradecenter.ordersuccess.uri");
        param = "order_id=" + SqlDetail.getParamValue("orderId");
        process(true,false);
    }

}
