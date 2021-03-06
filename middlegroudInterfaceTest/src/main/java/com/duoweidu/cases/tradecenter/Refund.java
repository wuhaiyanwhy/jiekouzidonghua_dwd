package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.RefundData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Refund extends TradeCenterInterfaceTest {

    private RefundData model;

    @Test(dependsOnGroups = "msfCreateRefund", description = "执行退款", groups = "msfRefund")
    public void msfRefund() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.refund"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateRefundTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(RefundData.class);
            msfDetailAssert();
        }
    }

    @Test(dependsOnGroups = "iqgCreateRefund", description = "执行退款", groups = "iqgRefund")
    public void iqgRefund() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.refund"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.iqgCreateRefundTradeNo));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(RefundData.class);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateRefundTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "pay_trade_no", model.pay_trade_no);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.refund_amount));
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfAccountNumber, "account_number", model.origin_data.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.origin_data.refund_amount));
        detailAssertTest("", "reverse", model.reverse);

    }
    private void iqgDetailAssert() {
        detailAssertTest(TradecenterConfig.iqgCreateRefundTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.iqgCreatePayTradeNo, "pay_trade_no", model.pay_trade_no);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.refund_amount));
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.iqgAccountNumber, "account_number", model.origin_data.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.origin_data.refund_amount));
        detailAssertTest("", "reverse", model.reverse);

    }
}
