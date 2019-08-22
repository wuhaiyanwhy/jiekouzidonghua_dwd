package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.QueryRefundData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryRefund extends TradeCenterInterfaceTest {

    private QueryRefundData model;

    @Test(dependsOnGroups = "msfRefund", description = "查询退款")
    public void msfQueryRefund() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_refund"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.msfCreateRefundTradeNo));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryRefundData.class);
            msfDetailAssert();
        }
    }
    @Test(dependsOnGroups = "iqgRefund", description = "查询退款")
    public void iqgQueryRefund() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_refund"));
        list.add(new BasicNameValuePair("tradeNo", TradecenterConfig.iqgCreateRefundTradeNo));

        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryRefundData.class);
            iqgDetailAssert();
        }
    }

    private void msfDetailAssert() {
        detailAssertTest(TradecenterConfig.msfCreateRefundTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "pay_trade_no", model.pay_trade_no);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.refund_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundTypeCode"), "refund_type_code", model.refund_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundDesc"), "refund_desc", model.refund_desc);
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.msfAccountNumber, "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "origin_data.refund_amount",String.valueOf(model.origin_data.refund_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "msfCurrency"), "origin_data.currency",String.valueOf(model.origin_data.currency));
        detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "origin_data.pay_trade_no", model.origin_data.pay_trade_no);
    }

    private void iqgDetailAssert() {
        detailAssertTest(TradecenterConfig.iqgCreateRefundTradeNo, "trade_no", model.trade_no);
        detailAssertTest(TradecenterConfig.iqgCreatePayTradeNo, "pay_trade_no", model.pay_trade_no);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "refund_amount", String.valueOf(model.refund_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundTypeCode"), "refund_type_code", model.refund_type_code);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "refundDesc"), "refund_desc", model.refund_desc);
        detailAssertTest("origin_data", model.origin_data.toString());
        detailAssertTest(TradecenterConfig.iqgAccountNumber, "origin_data.account_number", model.origin_data.account_number);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "createRefundAmount"), "origin_data.refund_amount",String.valueOf(model.origin_data.refund_amount));
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "iqgCurrency"), "origin_data.currency",String.valueOf(model.origin_data.currency));
        detailAssertTest(TradecenterConfig.iqgCreatePayTradeNo, "origin_data.pay_trade_no", model.origin_data.pay_trade_no);
    }
}
