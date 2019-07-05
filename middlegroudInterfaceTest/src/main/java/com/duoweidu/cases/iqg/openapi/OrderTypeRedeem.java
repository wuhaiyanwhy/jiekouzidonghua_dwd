package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class OrderTypeRedeem extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "未领用订单")
    public void order_type_redeem_true() {
        setUrl("order.type.redeem.uri");
        process(false,false);
    }
}
