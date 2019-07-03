package com.duoweidu.cases.tradecenterOpadmin;

import com.duoweidu.cases.interfaces.TradeCenterOpadminInterfaceTest;
import com.duoweidu.model.tradecenteropadmin.HistoryData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class History extends TradeCenterOpadminInterfaceTest {

    private HistoryData model;

    @Test(description = "查询账户资金日志")
    public void history() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("method", "get account.history"));
        list.add(new BasicNameValuePair("pageNum", "2"));
        list.add(new BasicNameValuePair("pageSize", "10"));
        process(list, true, true);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(HistoryData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("id", model.list.get(i).id);
            detailAssertTest("before_available_amount", String.valueOf(model.list.get(i).before_available_amount));
            detailAssertTest("before_frozen_amount", String.valueOf(model.list.get(i).before_frozen_amount));
            detailAssertTest("change_amount", model.list.get(i).change_amount);
            detailAssertTest("change_code", model.list.get(i).change_code);
            detailAssertTest("after_available_amount", model.list.get(i).after_available_amount);
            detailAssertTest("after_frozen_amount", String.valueOf(model.list.get(i).after_frozen_amount));
            detailAssertTest("created_at", model.list.get(i).created_at);
        }
        detailAssertTest("total_cnt", model.total_cnt);
        detailAssertTest("total_page", model.total_page);

    }
}
