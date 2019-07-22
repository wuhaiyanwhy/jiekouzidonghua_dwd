package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.ActivityGetactivityinfoData;
import org.testng.annotations.Test;

public class ActivityGetactivityinfo extends JszInterfaceTest {

    private ActivityGetactivityinfoData model;

    @Test(description = "活动详情")
    public void activityGetactivityinfo() {
        setUrl("activityGetactivityinfo.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
        model = sparseJson(ActivityGetactivityinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest( 10000, "id", model.id);
        detailAssertTest(34500 ,"market_price", model.market_price);
        detailAssertTest(2 ,"sale_price", model.sale_price);
        detailAssertTest(1 ,"commission_price", model.commission_price);
        detailAssertTest( "2019-05-30 15:59:58","start_time", model.start_time);
        detailAssertTest( "2022-06-30 15:59:58","end_time", model.end_time);
        detailAssertTest( "left_stock", model.left_stock);
        detailAssertTest( "need_book", model.need_book);
        detailAssertTest( "allow_take_out", model.allow_take_out);
        detailAssertTest( 1,"refund_type", model.refund_type);
        detailAssertTest(1, "redeem_period", model.redeem_period);
        detailAssertTest( "redeem_time", model.redeem_time);
        detailAssertTest( "refund_expired", model.refund_expired);
//        detailAssertTest( "poster", model.poster);
        detailAssertTest( 3,"sales_volume", model.sales_volume);
        detailAssertTest( "images",model.item.images);
        detailAssertTest( "巨食阵接口测试品(勿动)","name", model.item.name);
        detailAssertTest( "description", model.item.description);
        detailAssertTest( 1,"enabled", model.item.enabled);
        detailAssertTest( "tips", model.tips);
        detailAssertTest( "description", model.description);
        detailAssertTest( "commission_price", model.commission_price);
        detailAssertTest( 96718,"id", model.branch.id);
        detailAssertTest( "31.161075","lat", model.branch.lat);
        detailAssertTest( "121.4302","lng", model.branch.lng);
        detailAssertTest( "name", model.branch.name);
        detailAssertTest( "address", model.branch.address);
        detailAssertTest( "logo", model.branch.logo);
        detailAssertTest( "tel", model.branch.tel);
        detailAssertTest( 1,"enabled", model.branch.enabled);
        detailAssertTest( "distance", model.branch.distance);
        detailAssertTest( "end_timestamp", model.end_timestamp);
        detailAssertTest( true,"enabled", model.enabled);

        for (int i = 0; i < model.special_tips.size(); i++) {
            detailAssertTest( "icon", model.special_tips.get(i).icon);
            detailAssertTest( "key", model.special_tips.get(i).key);
            detailAssertTest( "text", model.special_tips.get(i).text);
        }
        for (int i = 0; i < model.tips_array.size(); i++) {
            detailAssertTest("text", model.tips_array.get(i).text);
        }
        detailAssertTest( "兑换时间","title", model.tips_array.get(0).title);
        detailAssertTest( "有效期","title", model.tips_array.get(1).title);
        detailAssertTest( "text", model.tips_array.get(0).text);
    }
}
