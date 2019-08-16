package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Withdraw extends TradeCenterInterfaceTest {

    @Test(description = "提现")
    public void jszWithdraw() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.withdraw"));
        list.add(new BasicNameValuePair("trade_no", TradecenterConfig.jszCreateWithdrawTradeNo));

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
    }
}
