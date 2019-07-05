package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;


public class Getpayment extends IqgInterfaceTest {

    @Test(dependsOnGroups = "orderTrue",description = "查询支付状态")
    public void getpayment_true() {
        url = ConfigFileUrl.getUrlByKey("getpayment.uri") + "/" + SqlDetail.getParamValue("orderId") + "/status";
        pathId = SqlDetail.getPathId("getpayment.uri");
        param = "confirmed=1";
        process(true,false);
    }
}
