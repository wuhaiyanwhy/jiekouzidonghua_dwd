package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.RefundInitData;
import org.testng.annotations.Test;

public class RefundInit extends FybInterfaceTest {

    private RefundInitData model;

    @Test(dependsOnGroups = "loginTrue",description = "退款申请初始化")
    public void refundInit() {
        setUrl("refund.init.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
        model = sparseJson(RefundInitData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.reasonList.size(); i++) {
            assertNotEmpty("reasonList.get(i).id", model.reasonList.get(i).id);
            assertNotEmpty("reasonList.get(i).type", model.reasonList.get(i).type);
            assertNotEmpty("reasonList.get(i).name", model.reasonList.get(i).name);
            assertNotEmpty("reasonList.get(i).priority", model.reasonList.get(i).priority);
            assertNotEmpty("reasonList.get(i).enabled", model.reasonList.get(i).enabled);
        }
        for (int i = 0; i < model.refundMethodList.size(); i++) {
            assertNotEmpty("refundMethodList.get(i).id", model.refundMethodList.get(i).id);
            assertNotEmpty("refundMethodList.get(i).name", model.refundMethodList.get(i).name);
        }
        assertNotEmpty("salesRefundType", model.salesRefundType);
    }
}
