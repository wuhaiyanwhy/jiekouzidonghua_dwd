package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class refund_detail_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "退款详情")
    public void refund_detail_true() {
        setUrl("refund.detail.uri");
        param = "refundOrderId=" + SqlDetail.getParamValue("refundOrderId");
        process(true,false);
    }
}
