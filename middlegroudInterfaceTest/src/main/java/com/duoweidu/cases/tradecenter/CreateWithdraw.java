package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.tradecenter.CreateWithdrawData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CreateWithdraw extends TradeCenterInterfaceTest {

    private CreateWithdrawData model;

    @Test(description = "创建提现单")
    public void jszCreateWithdraw() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.create_withdraw"));
        list.add(new BasicNameValuePair("account_number", TradecenterConfig.jszAccountNumber));
        list.add(new BasicNameValuePair("channel", "Wxpay/WxpayMp"));
        list.add(new BasicNameValuePair("withdraw_amount", SqlDetail.getInstance().getParamValue(0, "createWithdrawAmount")));
        list.add(new BasicNameValuePair("currency", "CNY"));
        list.add(new BasicNameValuePair("target_account", SqlDetail.getInstance().getParamValue(0, "jszOpenid")));
        list.add(new BasicNameValuePair("remark", "测试提现"));
        list.add(new BasicNameValuePair("withdraw_type_code", "withdraw_type_code"));
        list.add(new BasicNameValuePair("withdraw_type_desc", "withdraw_type_desc"));

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(CreateWithdrawData.class);
            TradecenterConfig.jszCreateWithdrawTradeNo = model.trade_no;
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.jszCreateWithdrawTradeNo, "trade_no", model.trade_no);
        detailAssertTest("service_charge", String.valueOf(model.service_charge));
        detailAssertTest("", "reverse", "");
    }
}
