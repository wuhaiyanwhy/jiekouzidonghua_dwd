package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.TradeNoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateAdjust extends TradeCenterInterfaceTest {

    private TradeNoData model;

    @Test(dependsOnGroups = "msfCreate", description = "创建调账单", groups = "msfCreateAdjust")
    public void msfCreateAdjust() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.create_adjust"));
        list.add(new BasicNameValuePair("adjustAmount", SqlDetail.getParamValue(0, "adjustAmount")));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        list.add(new BasicNameValuePair("currency", SqlDetail.getParamValue(0, "msfCurrency")));
        list.add(new BasicNameValuePair("adjustTypeCode", SqlDetail.getParamValue(0, "adjustTypeCode")));
        list.add(new BasicNameValuePair("adjustDesc", SqlDetail.getParamValue(0, "adjustDesc")));
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(TradeNoData.class);
            TradecenterConfig.msfCreateAdjustTradeNo = model.trade_no;
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("trade_no", model.trade_no);
        detailAssertTest("", "reverse", model.reverse);
    }
}
