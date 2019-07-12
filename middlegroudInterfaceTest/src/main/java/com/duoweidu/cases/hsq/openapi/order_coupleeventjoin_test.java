package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class order_coupleeventjoin_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "邀请好友参团")
    public void order_coupleeventjoin_true() {
        setUrl("order.coupleeventjoin.uri");
        param = "orderId="+ SqlDetail.getParamValue("orderId");
        process(true,false);
    }
}
