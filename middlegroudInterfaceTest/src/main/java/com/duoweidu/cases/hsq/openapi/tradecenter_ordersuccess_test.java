package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 已切到积分入淘流程，暂时无需详细断言
 */
public class tradecenter_ordersuccess_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "积分订单成功页")
    public void tradecenter_ordersuccess_true() {
        setUrl("tradecenter.ordersuccess.uri");
        param = "order_id=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
    }

}
