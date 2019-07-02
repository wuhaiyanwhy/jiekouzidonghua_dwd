package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.TradeNoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateRecharge extends TradeCenterInterfaceTest {

    private TradeNoData model;

    @Test(dependsOnGroups = "msfCreate", description = "创建充值单", groups = "createRecharge")
    public void msfCreateRecharge() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.create_recharge"));
        list.add(new BasicNameValuePair("rechargeAmount", SqlTradecenter.getParamValue(0, "rechargeAmount")));
        list.add(new BasicNameValuePair("rechargeTypeCode", SqlTradecenter.getParamValue(0, "rechargeTypeCode")));
        list.add(new BasicNameValuePair("rechargeDesc", SqlTradecenter.getParamValue(0, "rechargeDesc")));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        list.add(new BasicNameValuePair("channel", SqlTradecenter.getParamValue(0, "channel")));
        list.add(new BasicNameValuePair("currency", SqlTradecenter.getParamValue(0, "msfCurrency")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(TradeNoData.class);
            detailAssert();
            //储存返回的trade_no
            TradecenterConfig.msfCreateRechargeTradeNo = model.trade_no;
        }
    }

    private void detailAssert() {

        detailAssertTest("trade_no", model.trade_no);
        detailAssertTest("", "reverse", model.reverse);
    }
}
