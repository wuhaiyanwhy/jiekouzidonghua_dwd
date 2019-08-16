package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.UpdateSubOrderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UpdateSubOrder extends TradeCenterInterfaceTest {

    private UpdateSubOrderData model;

    @Test(dependsOnGroups = "msfCreateOrder", description = "上传子订单信息")
    public void msfUpdateSubOrder() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "order.update_sub_order"));
        list.add(new BasicNameValuePair("subOrderNo", TradecenterConfig.msfCreateOrderSubOrderNo));
        list.add(new BasicNameValuePair("orderStatus", SqlDetail.getInstance().getInstance().getParamValue(0, "orderStatus")));
//        list.add(new BasicNameValuePair("settleAmount", SqlDetail.getInstance().getParamValue(0, "settleAmount")));
//        list.add(new BasicNameValuePair("commissionAmount", SqlDetail.getInstance().getParamValue(0, "commissionAmount")));
        list.add(new BasicNameValuePair("refundStatus", SqlDetail.getInstance().getParamValue(0, "refundStatus")));
        list.add(new BasicNameValuePair("refundAmount", SqlDetail.getInstance().getParamValue(0, "refundAmount")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(UpdateSubOrderData.class);
            msfDetailAssert();
        }
    }

    @Test(dependsOnGroups = "iqgCreateOrder", description = "上传子订单信息")
    public void iqgUpdateSubOrder() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "order.update_sub_order"));
        list.add(new BasicNameValuePair("subOrderNo", TradecenterConfig.iqgCreateOrderSubOrderNo));
        list.add(new BasicNameValuePair("orderStatus", SqlDetail.getInstance().getInstance().getParamValue(0, "orderStatus")));
//        list.add(new BasicNameValuePair("settleAmount", SqlDetail.getInstance().getParamValue(0, "settleAmount")));
//        list.add(new BasicNameValuePair("commissionAmount", SqlDetail.getInstance().getParamValue(0, "commissionAmount")));
        list.add(new BasicNameValuePair("refundStatus", SqlDetail.getInstance().getParamValue(0, "refundStatus")));
        list.add(new BasicNameValuePair("refundAmount", SqlDetail.getInstance().getParamValue(0, "refundAmount")));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(UpdateSubOrderData.class);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "order_no", model.order_no);
        detailAssertTest(TradecenterConfig.msfCreateOrderSubOrderNo, "order_no", model.sub_order_no);
        detailAssertTest("changes", model.changes.toString());
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "orderStatus"), "order_status", model.changes.order_status);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundStatus"), "refund_status", String.valueOf(model.changes.refund_status));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundAmount"), "refund_amount", String.valueOf(model.changes.refund_amount));
        //detailAssertTest(SqlDetail.getInstance().getParamValue(0, "commissionAmount"), "commission_amount", String.valueOf(model.changes.commission_amount));
        detailAssertTest("", "reverse", model.reverse);

    }

    private void iqgDetailAssert() {
        detailAssertTest(TradecenterConfig.iqgCreateOrderOrderNo, "order_no", model.order_no);
        detailAssertTest(TradecenterConfig.iqgCreateOrderSubOrderNo, "order_no", model.sub_order_no);
        detailAssertTest("changes", model.changes.toString());
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "orderStatus"), "order_status", model.changes.order_status);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundStatus"), "refund_status", String.valueOf(model.changes.refund_status));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundAmount"), "refund_amount", String.valueOf(model.changes.refund_amount));
        //detailAssertTest(SqlDetail.getInstance().getParamValue(0, "commissionAmount"), "commission_amount", String.valueOf(model.changes.commission_amount));
        detailAssertTest("", "reverse", model.reverse);

    }
}
