package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.hsq.ActivityAssistanceuserskulistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ActivityAssistanceuserskulist extends HsqInterfaceTest {


    private ActivityAssistanceuserskulistData model;

    private void genActivity(int eventStatus) {
        setUrl("activity.assistanceuserskulist.uri");
        param = "token=" + SqlDetail.getParamValue("token") +
                "&pageNum=1&pageLimit=10needPagination=1&eventStatus=" + eventStatus + "&activityType=1&terminal=aliapp";
        process(true,false);
    }

    @Test(description = "我的免单-助力中")
    public void activityAssistanceuserskulist() {
        genActivity(2);
    }

    @Test(description = "我的免单-助力成功")
    public void activityAssistanceuserskulistTrue() {
        genActivity(3);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(true);
            model = sparseJson(ActivityAssistanceuserskulistData.class);
            detailAssertTrue();
        }
    }

    @Test(description = "我的免单-助力失败")
    public void activityAssistanceuserskulistFalse() {
        genActivity(4);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(true);
            model = sparseJson(ActivityAssistanceuserskulistData.class);
            detailAssertFalse();
        }

    }

    private void detailAssertFalse() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest(4, "event_status", model.list.get(i).event_status);
        }

    }

    private void detailAssertTrue() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("event_id", model.list.get(i).event_id);
            detailAssertTest("assistance_id", model.list.get(i).assistance_id);
            detailAssertTest(3, "event_status", model.list.get(i).event_status);
            detailAssertTest(23391725, "owner_id", model.list.get(i).owner_id);
            detailAssertTest("launch_start_time", model.list.get(i).launch_start_time);
            detailAssertTest("launch_end_time", model.list.get(i).launch_end_time);
            detailAssertTest("join_count", String.valueOf(model.list.get(i).join_count));
            detailAssertTest("booster_num", model.list.get(i).booster_num);
//            detailAssertTest("share_image_url", model.list.get(i).share_image_url);
            detailAssertTest("sku_id", model.list.get(i).sku_id);
            detailAssertTest("title", model.list.get(i).title);
            detailAssertTest("activity_status", model.list.get(i).activity_status);
            detailAssertTest("status", model.list.get(i).status);
            detailAssertTest("product_id", model.list.get(i).product_id);
            detailAssertTest("activity_id", model.list.get(i).activity_id);
            detailAssertTest("activity_type", model.list.get(i).activity_type);
            detailAssertTest("activity_price", String.valueOf(model.list.get(i).activity_price));
            detailAssertTest("single_price", model.list.get(i).single_price);
            detailAssertTest("name", model.list.get(i).name);
            detailAssertTest("thunbnail", model.list.get(i).thunbnail);
            detailAssertTest("left_stock", model.list.get(i).left_stock);
            detailAssertTest("locked_stock", model.list.get(i).locked_stock);
            detailAssertTest("activity_stock", model.list.get(i).activity_stock);
            detailAssertTest("order_id", model.list.get(i).order_id);
            detailAssertTest("can_buy", model.list.get(i).can_buy);

        }
    }

}
