package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.hsq.ActivityAssistanceeventdetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ActivityAssistanceeventdetail extends HsqInterfaceTest {

    private ActivityAssistanceeventdetailData model;

    @Test(description = "创建助力",groups = "activityAssistanceeventdetail")
    public void activityAssistanceeventdetail() {
        setUrl("activity.assistanceeventdetail.uri");
        param = "activityId=" + SqlDetail.getParamValue(2, "noPayActivityId") +
                "&activityType=1" +
                "&token=" + SqlDetail.getParamValue("token");
        process(false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ActivityAssistanceeventdetailData.class);
            detailAssert();
            //储存接口返回的eventId
            HsqOpenapiConfig.activityEventId = model.assistance_event.event_id;
            //更新助力免单数据，使其可以下单
            SqlDetail.hsqUpdateAssistanceEvent();
        }
    }

    private void detailAssert() {
        detailAssertTest(139, "activity_id", model.activity_id);
        detailAssertTest(34535, "sku_id", model.sku_id);
        detailAssertTest("http://img2.haoshiqi.net/ma83cfe38517bb7812d3562f7d1486f3e1.jpg", "main_pic", model.main_pic);
        detailAssertTest("接口自动化测试专用助力免单 100g", "name", model.name);
        detailAssertTest("接口自动化测试专用助力免单 （勿动）", "activity_title", model.activity_title);
        detailAssertTest("活动规则", "activity_rule", model.activity_rule);
        detailAssertTest("Hi 小主～", "title", model.title);
        detailAssertTest("我发现了一件好货，帮我助力一下吧～", "sub_title", model.sub_title);
        detailAssertTest(1, "status", model.status);
        detailAssertTest(2, "activity_status", model.activity_status);
        detailAssertTest(0, "activity_price", model.activity_price);
        detailAssertTest(9999, "single_price", model.single_price);
        detailAssertTest(1559544600, "start_time", model.start_time);
        detailAssertTest(2147483647, "end_time", model.end_time);
        detailAssertTest(1, "booster_num", model.booster_num);
        detailAssertTest(32767, "join_times_limit", model.join_times_limit);
//        detailAssertTest("assistance_event.eventUser", model.assistance_event.eventUser);
        detailAssertTest(23391725, "assistance_event.eventUser.get(0).user_id", model.assistance_event.eventUser.get(0).user_id);
        detailAssertTest("华健15420995228891", "assistance_event.eventUser.get(0).username", model.assistance_event.eventUser.get(0).username);
        detailAssertTest("https://tfs.alipayobjects.com/images/partner/T1Y_duXiBbXXXXXXXX", "assistance_event.eventUser.get(0).avatar", model.assistance_event.eventUser.get(0).avatar);
        detailAssertTest(true, "assistance_event.eventUser.get(0).owner", model.assistance_event.eventUser.get(0).owner);
        detailAssertTest(true, "assistance_event.is_join", model.assistance_event.is_join);
        detailAssertTest(1, "assistance_event.booster_num", model.assistance_event.booster_num);
//        detailAssertTest(true, "assistance_event.is_new", model.assistance_event.is_new);
        detailAssertTest(28745, "product_id", model.product_id);
        detailAssertTest(true, "can_share", model.can_share);
        detailAssertTest("success_event", model.success_event);
        detailAssertTest("success_event.get(0).userInfo", model.success_event.get(0).userInfo.toString());
        detailAssertTest("success_event.get(0).userInfo.user_id", String.valueOf(model.success_event.get(0).userInfo.user_id));
        detailAssertTest("success_event.get(0).userInfo.username", model.success_event.get(0).userInfo.username);
        detailAssertTest("success_event.get(0).userInfo.avatar", model.success_event.get(0).userInfo.avatar);
        detailAssertTest("success_event.get(0).created_at", String.valueOf(model.success_event.get(0).created_at));
//        detailAssertTest("success_event.get(0).success_time", model.success_event.get(0).success_time);

    }

}
