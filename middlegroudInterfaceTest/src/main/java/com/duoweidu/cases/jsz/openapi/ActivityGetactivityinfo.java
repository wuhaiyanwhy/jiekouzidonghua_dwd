package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.ActivityGetactivityinfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ActivityGetactivityinfo extends JszInterfaceTest {

    private ActivityGetactivityinfoData model;

    @Test(description = "活动详情")
    public void activityGetactivityinfo() {
        setUrl("activityGetactivityinfo.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
        model = sparseJson(ActivityGetactivityinfoData.class);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(SqlDetail.getInstance().getParamValue("activityId"), "id", model.id);
        detailAssertTest("market_price", model.market_price);
        detailAssertTest("sale_price", model.sale_price);
        detailAssertTest("commission_price", model.commission_price);
        detailAssertTest("start_time", model.start_time);
        detailAssertTest("end_time", model.end_time);
        detailAssertTest("left_stock", model.left_stock);
        detailAssertTest("need_book", model.need_book);
        detailAssertTest("allow_take_out", model.allow_take_out);
        detailAssertTest("refund_type", model.refund_type);
        detailAssertTest("redeem_period", model.redeem_period);
        detailAssertTest("redeem_time", model.redeem_time);
        detailAssertTest("refund_expired", model.refund_expired);
//        detailAssertTest("poster", model.poster);
        detailAssertTest("sales_volume", model.sales_volume);
        detailAssertTest("images", model.item.images);
        detailAssertTest("name", model.item.name);
//        detailAssertTest("description", model.item.description);
        detailAssertTest(1, "enabled", model.item.enabled);
        detailAssertTest("tips", model.tips);
//        detailAssertTest("description", model.description);
        detailAssertTest("commission_price", model.commission_price);
        detailAssertTest("id", model.branch.id);
        detailAssertTest("lat", model.branch.lat);
        detailAssertTest("lng", model.branch.lng);
        detailAssertTest("name", model.branch.name);
        detailAssertTest("address", model.branch.address);
        detailAssertTest("logo", model.branch.logo);
        detailAssertTest("tel", model.branch.tel);
        detailAssertTest(1, "enabled", model.branch.enabled);
        detailAssertTest("distance", model.branch.distance);
        detailAssertTest("end_timestamp", model.end_timestamp);
//        detailAssertTest(false, "enabled", model.enabled);

        for (int i = 0; i < model.special_tips.size(); i++) {
            detailAssertTest("icon", model.special_tips.get(i).icon);
            detailAssertTest("key", model.special_tips.get(i).key);
            detailAssertTest("text", model.special_tips.get(i).text);
        }
        for (int i = 0; i < model.tips_array.size(); i++) {
            detailAssertTest("text", model.tips_array.get(i).text);
        }
        detailAssertTest("兑换时间", "title", model.tips_array.get(0).title);
        detailAssertTest("title", model.tips_array.get(0).title);
        detailAssertTest("text", model.tips_array.get(0).text);
    }
}


