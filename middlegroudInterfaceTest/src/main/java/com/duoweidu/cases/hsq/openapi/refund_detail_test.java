package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.RefundDetailData;
import org.testng.annotations.Test;

public class refund_detail_test extends HsqInterfaceTest {

    private RefundDetailData model;

    @Test(dependsOnGroups = "loginTrue",description = "退款详情")
    public void refund_detail_true() {
        setUrl("refund.detail.uri");
        param = "refundOrderId=" + SqlDetail.getInstance().getParamValue("refundOrderId");
        process(true,false);
        model = sparseJson(RefundDetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.auditList.size(); i++) {
            detailAssertTest("auditList.get(i).type", model.auditList.get(i).type);
            detailAssertTest("auditList.get(i).auditUserId", model.auditList.get(i).auditUserId);
            detailAssertTest("auditList.get(i).time", model.auditList.get(i).time);
            detailAssertTest("auditList.get(i).status", model.auditList.get(i).status);
            detailAssertTest("auditList.get(i).statusDesc", model.auditList.get(i).statusDesc);
            detailAssertTest("auditList.get(i).amount", model.auditList.get(i).amount);

        }
        detailAssertTest("refundInfo.id", model.refundInfo.id);
        detailAssertTest("refundInfo.reason", model.refundInfo.reason);
        detailAssertTest("refundInfo.method", model.refundInfo.method);
        detailAssertTest("refundInfo.refundMoney", model.refundInfo.refundMoney);
        detailAssertTest("refundInfo.amount", model.refundInfo.amount);
        detailAssertTest("refundInfo.amountDesc", model.refundInfo.amountDesc);
        detailAssertTest("refundInfo.applyTime", model.refundInfo.applyTime);
        detailAssertTest("refundInfo.auditExpiredTime", model.refundInfo.auditExpiredTime);
        detailAssertTest("refundInfo.type", model.refundInfo.type);
        detailAssertTest("refundInfo.refundType", model.refundInfo.refundType);

    }
}
