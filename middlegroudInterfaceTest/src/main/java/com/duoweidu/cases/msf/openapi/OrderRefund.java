package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderRefund extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "申请退款页面接口")
    public void orderRefund() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_REFUND);
        param = "order_id=" + TestSql.getValue("order_id");
        process(false,false);
    }
}
