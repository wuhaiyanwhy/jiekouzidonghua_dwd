package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class RefundInit extends FybInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款申请初始化")
    public void refundInit() {
        setUrl("refund.init.uri");
        param = "orderId=" + SqlDetail.getParamValue("orderId");
        process(true,false);
    }
}
