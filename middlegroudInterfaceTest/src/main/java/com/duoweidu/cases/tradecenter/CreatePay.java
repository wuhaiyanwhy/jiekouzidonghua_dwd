package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.CreatePayData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreatePay extends TradeCenterInterfaceTest {

    public void commonParameters(List<NameValuePair> list, String orderType,String orderSettle) {
        list.add(new BasicNameValuePair("method", "trade.create_pay"));
        list.add(new BasicNameValuePair("subject", "商品描述dayan哈哈"));
        list.add(new BasicNameValuePair("totalAmount", SqlDetail.getInstance().getParamValue(0, "totalAmount")));
        list.add(new BasicNameValuePair("payTypeCode", SqlDetail.getInstance().getParamValue(0, "payTypeCode")));
        if (orderType.equals("jsz")) {
            list.add(new BasicNameValuePair("channel", "Wxpay/WxpayMp"));
            list.add(new BasicNameValuePair("payDesc", "购买等..."));
            if (orderSettle.equals("jszSettle")) {
                list.add(new BasicNameValuePair("orderNo", TradecenterConfig.jszCreateSettleOrderOrderNo));
            }else{
                list.add(new BasicNameValuePair("orderNo", TradecenterConfig.jszCreateOrderOrderNo));
            }

            list.add(new BasicNameValuePair("currency", "CNY"));
            list.add(new BasicNameValuePair("openid", SqlDetail.getInstance().getParamValue(0, "jszOpenid")));
        } else {
            list.add(new BasicNameValuePair("channel", SqlDetail.getInstance().getParamValue(0, "channel")));
            list.add(new BasicNameValuePair("payDesc", SqlDetail.getInstance().getParamValue(0, "payDesc")));
            if (orderType.equals("iqg")) {
                list.add(new BasicNameValuePair("orderNo", TradecenterConfig.iqgCreateOrderOrderNo));
                list.add(new BasicNameValuePair("currency", SqlDetail.getInstance().getParamValue(0, "iqgCurrency")));
            } else {
                list.add(new BasicNameValuePair("orderNo", TradecenterConfig.msfCreateOrderOrderNo));
                list.add(new BasicNameValuePair("currency", SqlDetail.getInstance().getParamValue(0, "msfCurrency")));
            }
        }
    }

    private CreatePayData model;

    @Test(dependsOnGroups = "msfCreateOrder", description = "预支付(创建支付单)", groups = "msfCreatePay")
    public void msfCreatePay() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "msf","noSettle");
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreatePayData.class);
            TradecenterConfig.msfCreatePayTradeNo = model.trade_no;
            detailAssert("msf","noSettle");
        }
    }

    @Test(dependsOnGroups = "iqgCreateOrder", description = "预支付(创建支付单)", groups = "iqgCreatePay")
    public void iqgCreatePay() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "iqg","noSettle");
        TradecenterConfig.accountType = "DWD_IQG_COIN";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreatePayData.class);
            TradecenterConfig.iqgCreatePayTradeNo = model.trade_no;
            detailAssert("iqg","noSettle");
        }
    }

    @Test(dependsOnGroups = "jszCreateOrder", description = "预支付(创建支付单)", groups = "jszCreatePay")
    public void jszCreatePay() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "jsz","noSettle");
        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreatePayData.class);
            TradecenterConfig.jszCreatePayTradeNo = model.trade_no;
            detailAssert("jsz","noSettle");
        }
    }

    @Test(dependsOnGroups = "jszCreateOrder", description = "预支付(创建支付单)")
    public void jszCreateSettlePay() {
        List<NameValuePair> list = new LinkedList<>();
        commonParameters(list, "jsz","jszSettle");
        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreatePayData.class);
            TradecenterConfig.jszCreatePaySettleTradeNo = model.trade_no;
            detailAssert("jsz","jszSettle");
        }
    }

    private void detailAssert(String type,String orderSettle) {
        if (type.equals("iqg")) {
            detailAssertTest(TradecenterConfig.iqgCreateOrderOrderNo, "order_no", model.order_no);
            detailAssertTest(TradecenterConfig.iqgCreatePayTradeNo, "trade_no", model.trade_no);
            detailAssertTest("", "sign_data", model.sign_data);
        } else if (type.equals("jsz")) {
            if(orderSettle.equals("jszSettle")){
                detailAssertTest(TradecenterConfig.jszCreateSettleOrderOrderNo, "order_no", model.order_no);
                detailAssertTest(TradecenterConfig.jszCreatePaySettleTradeNo, "trade_no", model.trade_no);
            }else {
                detailAssertTest(TradecenterConfig.jszCreateOrderOrderNo, "order_no", model.order_no);
                detailAssertTest(TradecenterConfig.jszCreatePayTradeNo, "trade_no", model.trade_no);
            }
            detailAssertTest("sign_data", model.sign_data);
        } else {
            detailAssertTest(TradecenterConfig.msfCreateOrderOrderNo, "order_no", model.order_no);
            detailAssertTest(TradecenterConfig.msfCreatePayTradeNo, "trade_no", model.trade_no);
            detailAssertTest("", "sign_data", model.sign_data);
        }
        detailAssertTest("", "reverse", model.reverse);
    }
}
