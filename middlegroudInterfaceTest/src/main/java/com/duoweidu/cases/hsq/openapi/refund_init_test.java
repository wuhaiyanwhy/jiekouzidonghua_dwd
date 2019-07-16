package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class refund_init_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款申请初始化")
    public void refund_init_true() {
        setUrl("refund.init.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
    }

}
