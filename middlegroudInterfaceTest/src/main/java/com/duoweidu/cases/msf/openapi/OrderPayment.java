package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderPayment extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "支付页面接口")
    public void orderPayment() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ORDER_PAYMENT);
        param = "activity_id=" + TestSql.getValue("pay_activity_id", 2);
        process(false, false);
        //线上无法下单
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
        }
    }
}
