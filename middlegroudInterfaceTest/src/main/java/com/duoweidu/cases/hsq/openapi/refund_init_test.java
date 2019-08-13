package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.RefundInitData;
import org.testng.annotations.Test;

public class refund_init_test extends HsqInterfaceTest {

    private RefundInitData model;

    @Test(dependsOnGroups = "loginTrue",description = "退款申请初始化")
    public void refund_init_true() {
        setUrl("refund.init.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
        model = sparseJson(RefundInitData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.reasonList.size(); i++) {
            detailAssertTest("reasonList.get(i).id", model.reasonList.get(i).id);
            detailAssertTest("reasonList.get(i).type", model.reasonList.get(i).type);
            detailAssertTest("reasonList.get(i).name", model.reasonList.get(i).name);
            detailAssertTest("reasonList.get(i).priority", model.reasonList.get(i).priority);
            detailAssertTest("reasonList.get(i).enabled", model.reasonList.get(i).enabled);
        }
        for (int i = 0; i < model.refundMethodList.size(); i++) {
            detailAssertTest("refundMethodList.get(i).id", model.refundMethodList.get(i).id);
            detailAssertTest("refundMethodList.get(i).name", model.refundMethodList.get(i).name);
        }
    }

}
