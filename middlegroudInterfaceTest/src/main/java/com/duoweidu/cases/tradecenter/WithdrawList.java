package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.tradecenter.WithdrawListData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class WithdrawList extends TradeCenterInterfaceTest {

    private WithdrawListData model;

    @Test(description = "查询提现列表")
    public void jszWithdrawList() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "trade.withdraw_list"));
        list.add(new BasicNameValuePair("account_number", TradecenterConfig.jszAccountNumber));
        list.add(new BasicNameValuePair("order", "{\"id\":\"desc\", \"created_at\": \"desc\"}"));

        TradecenterConfig.accountType = "DWD_JSZ_COMMISSION";
        process(list, true, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(WithdrawListData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("list", model.list);
        if (model.list.size() > 0) {
            for (int i = 0; i < model.list.size(); i++) {

                detailAssertTest("list.get(i).trade_no", model.list.get(i).trade_no);
                if (model.list.get(i).withdraw_status == 4)
                    detailAssertTest( "list.get(i).gateway_trade_no", model.list.get(i).gateway_trade_no);
                detailAssertTest("list.get(i).channel_id", model.list.get(i).channel_id);
                detailAssertTest("ist.get(i).channel_code", model.list.get(i).channel_code);
                detailAssertTest("list.get(i).channel_name", model.list.get(i).channel_name);
                detailAssertTest("list.get(i).withdraw_status", model.list.get(i).withdraw_status);
                detailAssertTest("list.get(i).withdraw_amount", model.list.get(i).withdraw_amount);
                detailAssertTest("list.get(i).service_charge", String.valueOf(model.list.get(i).service_charge));
                detailAssertTest("list.get(i).real_service_charge", String.valueOf(model.list.get(i).real_service_charge));
                detailAssertTest("CNY", "list.get(i).currency", model.list.get(i).currency);
                detailAssertTest("list.get(i).target_account", model.list.get(i).target_account);
                detailAssertTest("model.list.get(i).remark", model.list.get(i).remark);
//                detailAssertTest( "model.list.get(i).fail_reason", model.list.get(i).fail_reason);
                detailAssertTest("list.get(i).process_at", String.valueOf(model.list.get(i).process_at));
            }
        }
    }
}

