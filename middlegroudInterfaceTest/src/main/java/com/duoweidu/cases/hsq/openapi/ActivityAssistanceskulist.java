package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ActivityAssistanceskulistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;


public class ActivityAssistanceskulist extends HsqInterfaceTest {

    private ActivityAssistanceskulistData model;

    @Test(description = "助力免单列表")
    public void activityAssistanceskulist() {
        setUrl("activity.assistanceskulist.uri");
        param = "activityType=1&pageNum=1&pageLimit=10" +
        "&token=" + SqlDetail.getInstance().getParamValue("token");
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            process(true,true);
        }else if ("prod".equals(ConfigFileUrl.getEnv())) {
            process(true, false);
        }
        model = sparseJson(ActivityAssistanceskulistData.class);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("list", model.list);
        if (model.list.size() > 0 ) {
            for (int i = 0; i < model.list.size(); i++) {
                detailAssertTest("list.get(i).activity_id", model.list.get(i).activity_id);
                detailAssertTest("list.get(i).title", model.list.get(i).title);
                detailAssertTest("list.get(i).start_time", model.list.get(i).start_time);
                detailAssertTest("list.get(i).end_time", model.list.get(i).end_time);
                detailAssertTest("list.get(i).status", model.list.get(i).status);
                detailAssertTest("list.get(i).activity_status", model.list.get(i).activity_status);
                detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
                detailAssertTest("list.get(i).booster_num", model.list.get(i).booster_num);
                detailAssertTest("list.get(i).join_times_limit", model.list.get(i).join_times_limit);
                detailAssertTest("list.get(i).activity_rule", model.list.get(i).activity_rule);
                detailAssertTest("list.get(i).priority", model.list.get(i).priority);
                detailAssertTest("list.get(i).increase_stock", String.valueOf(model.list.get(i).increase_stock));
                detailAssertTest("list.get(i).left_stock", model.list.get(i).left_stock);
                detailAssertTest("list.get(i).locked_stock", String.valueOf(model.list.get(i).locked_stock));
                detailAssertTest("list.get(i).activity_stock", model.list.get(i).activity_stock);
                detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
                detailAssertTest("list.get(i).product_id", model.list.get(i).product_id);
                detailAssertTest("list.get(i).activity_type", model.list.get(i).activity_type);
                detailAssertTest("list.get(i).activity_price", String.valueOf(model.list.get(i).activity_price));
                detailAssertTest("list.get(i).single_price", model.list.get(i).single_price);
                detailAssertTest("list.get(i).name", model.list.get(i).name);
                detailAssertTest("list.get(i).thunbnail", model.list.get(i).thunbnail);
                detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
//                detailAssertTest("list.get(i).app_id", model.list.get(i).app_id);
                detailAssertTest("list.get(i).assistance_channel", model.list.get(i).assistance_channel);
                detailAssertTest("list.get(i).is_noticed", model.list.get(i).is_noticed);
            }
        }

    }
}
