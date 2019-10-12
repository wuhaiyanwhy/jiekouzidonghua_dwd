package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 无法一直申请退款，暂时无需详细断言
 */
public class OrderRefund extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "申请退款页面接口")
    public void orderRefund() {
        setUrl("order.refund.uri");
        param = "order_id=" + SqlDetail.getInstance().getParamValue("order_id");
        process(false,false);
    }
}
