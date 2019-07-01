package com.duoweidu.cases.tradecenter;

import com.duoweidu.cases.interfaces.TradeCenterInterfaceTest;
import com.duoweidu.config.TradecenterConfig;
import com.duoweidu.model.tradecenter.HistoryData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class History extends TradeCenterInterfaceTest {

    private HistoryData model;

    @Test(dependsOnGroups = "msfCreate", description = "查询账户资金日志(流水)")
    public void msf() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "account.history"));
        list.add(new BasicNameValuePair("accountNumber", TradecenterConfig.msfAccountNumber));
        list.add(new BasicNameValuePair("pageNum", "1"));
        list.add(new BasicNameValuePair("pageSize", "20"));
        list.add(new BasicNameValuePair("where", "{\"change_code\":{\"eq\":\"A-\", \"neq\":\"A+F-\"}, \"created_at\":{\"gte\":\"100\"}}"));
        list.add(new BasicNameValuePair("order", "{\"id\":\"asc\"}"));
        process(list, true, true);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(HistoryData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("record_id", model.list.get(i).record_id);
            detailAssertTest("before_available_amount", model.list.get(i).before_available_amount);
            detailAssertTest("before_frozen_amount", String.valueOf(model.list.get(i).before_frozen_amount));
            detailAssertTest("change_amount", model.list.get(i).change_amount);
            detailAssertTest("change_type", model.list.get(i).change_type);
            detailAssertTest("change_code", model.list.get(i).change_code);
            detailAssertTest("change_type_code", model.list.get(i).change_type_code);
            detailAssertTest("change_desc", model.list.get(i).change_desc);
            detailAssertTest("after_available_amount", model.list.get(i).after_available_amount);
            detailAssertTest("after_frozen_amount", String.valueOf(model.list.get(i).after_frozen_amount));
            detailAssertTest("related_trade_no", model.list.get(i).related_trade_no);
            detailAssertTest("created_at", model.list.get(i).created_at);
            detailAssertTest("account_type_code", model.list.get(i).account_type_code);
            detailAssertTest("account_type_desc", model.list.get(i).account_type_desc);
            detailAssertTest("DWD_MSF_HONEY", "currency", model.list.get(i).currency);

        }

        detailAssertTest("total_cnt", model.total_cnt);
        detailAssertTest("total_page", model.total_page);
        detailAssertTest("", "reverse", model.reverse);
    }
}
