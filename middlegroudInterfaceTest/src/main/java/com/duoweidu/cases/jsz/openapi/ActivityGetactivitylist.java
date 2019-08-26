package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.ActivityGetactivitylistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ActivityGetactivitylist extends JszInterfaceTest {

    private ActivityGetactivitylistData model;

    @Test(description = "活动列表")
    public void activityGetactivitylist() {
        setUrl("activityGetactivitylist.uri");
        param = "zoneId=" + SqlDetail.getInstance().getParamValue(0, "zoneId") +
                "&lng=" + SqlDetail.getInstance().getParamValue(0,"lng") +
                "&lat=" + SqlDetail.getInstance().getParamValue(0,"lat") +
                "&pageLimit=" + SqlDetail.getInstance().getParamValue(0,"pageLimit") +
                "&pageNum=" + SqlDetail.getInstance().getParamValue(0,"pageNum") ;
        process(true,false);
        model = sparseJson(ActivityGetactivitylistData.class);
//        detailAssert();
//        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssert();
//        }
    }

    private void detailAssert() {
        detailAssertTest("id", model.total_cnt);
        detailAssertTest("total_page", model.total_page);

        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("id", model.list.get(i).id);
            detailAssertTest("sale_price", model.list.get(i).sale_price);
            detailAssertTest("market_price", model.list.get(i).market_price);
            detailAssertTest("commission_price", model.list.get(i).commission_price);
            detailAssertTest("start_time", model.list.get(i).start_time);
            detailAssertTest("end_time", model.list.get(i).end_time);
            detailAssertTest("left_stock", model.list.get(i).left_stock);
//            detailAssertTest("stock", model.list.get(i).stock);
            detailAssertTest("redeem_period", model.list.get(i).redeem_period);
            detailAssertTest("need_book", model.list.get(i).need_book);
            detailAssertTest("allow_take_out", model.list.get(i).allow_take_out);
            detailAssertTest("refund_type", model.list.get(i).refund_type);
            detailAssertTest("refund_expired", model.list.get(i).refund_expired);
//            detailAssertTest("settle_price", model.list.get(i).settle_price);
//            detailAssertTest("day_buy_limit", model.list.get(i).day_buy_limit);
//            detailAssertTest("sales_volume", model.list.get(i).sales_volume);
//            detailAssertTest("poster", model.list.get(i).poster);
            detailAssertTest("redeem_time", model.list.get(i).redeem_time);
            detailAssertTest("row_status", model.list.get(i).row_status);
            detailAssertTest("created_at", model.list.get(i).created_at);
            detailAssertTest("branch_name", model.list.get(i).branch_name);
            detailAssertTest("lng", model.list.get(i).lng);
            detailAssertTest("lat", model.list.get(i).lat);
            detailAssertTest("item_name", model.list.get(i).item_name);
            detailAssertTest("item_image", model.list.get(i).item_image);
            detailAssertTest("distance", model.list.get(i).distance);
            detailAssertTest("end_timestamp", model.list.get(i).end_timestamp);
        }

        for (int i = 0; i < model.banner.size(); i++) {
            detailAssertTest("id", model.banner.get(i).id);
            detailAssertTest("title", model.banner.get(i).title);
            detailAssertTest("url", model.banner.get(i).url);
//            detailAssertTest("event_id", model.banner.get(i).event_id);
            detailAssertTest("need_login", model.banner.get(i).need_login);
            detailAssertTest("size", model.banner.get(i).size);
            detailAssertTest("id", model.banner.get(i).id);
            detailAssertTest("image_url", model.banner.get(i).image_url);
            detailAssertTest("id", model.banner.get(i).id);
//            detailAssertTest("width", model.banner.get(i).width);
//            detailAssertTest("height", model.banner.get(i).height);
        }
    }
}