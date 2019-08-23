package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.tradecenter.QueryWithdrawData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class QueryWithdraw extends TradeCenterInterfaceTest {

    private QueryWithdrawData model;

    @Test(description = "查询提现")
    public void jszQueryWithdraw() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.query_withdraw"));
        list.add(new BasicNameValuePair("trade_no", TradecenterConfig.jszCreateWithdrawTradeNo));

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(QueryWithdrawData.class);
            TradecenterConfig.jszCreateWithdrawTradeNo = model.trade_no;
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(TradecenterConfig.jszCreateWithdrawTradeNo, "trade_no", model.trade_no);
        if (model.withdraw_status == 4)
            detailAssertTest("gateway_trade_no", model.gateway_trade_no);
        detailAssertTest(3, "platform_id", model.platform_id);
        detailAssertTest(Integer.parseInt(SqlDetail.getInstance().getParamValue(0, "userId")), "platform_user_id", model.platform_user_id);
        detailAssertTest("global_user_id", String.valueOf(model.global_user_id));
        detailAssertTest("withdraw_status", model.withdraw_status);
        detailAssertTest("withdraw_amount", model.withdraw_amount);
        detailAssertTest("service_charge", String.valueOf(model.service_charge));
        detailAssertTest("real_service_charge", String.valueOf(model.real_service_charge));
        detailAssertTest("CNY", "currency", model.currency);
        detailAssertTest(SqlDetail.getInstance().getParamValue(0, "jszOpenid"), "target_account", model.target_account);
        detailAssertTest("测试提现", "remark", model.remark);
        detailAssertTest("", "fail_reason", model.fail_reason);
        detailAssertTest("process_at", String.valueOf(model.process_at));
        detailAssertTest("origin.return_code", model.origin.return_code);
        detailAssertTest("origin.return_msg", model.origin.return_msg);
        detailAssertTest("origin.result_code", model.origin.result_code);
        detailAssertTest("origin.err_code", model.origin.err_code);
        detailAssertTest("origin.err_code_des", model.origin.err_code_des);
        detailAssertTest(TradecenterConfig.jszCreateWithdrawTradeNo, "origin.partner_trade_no", model.origin.partner_trade_no);
        detailAssertTest("origin.mch_id", model.origin.mch_id);
        detailAssertTest("origin.appid", model.origin.appid);
        detailAssertTest("", "reverse", model.reverse);

    }
}

