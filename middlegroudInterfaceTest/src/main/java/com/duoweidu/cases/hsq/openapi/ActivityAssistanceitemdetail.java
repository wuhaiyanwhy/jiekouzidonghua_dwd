package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ActivityAssistanceitemdetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ActivityAssistanceitemdetail extends HsqInterfaceTest {

    private ActivityAssistanceitemdetailData model;

    private void genDetail(String activityId) {
        setUrl("activity.assistanceitemdetail.uri");
        param = "activityId=" + activityId +
                "&activityType=1";
        process(false,false);
    }

    @Test(description = "助力免单详情")
    public void noPayActivityAssistanceitemdetail() {
        genDetail(SqlDetail.getParamValue(2, "noPayActivityId"));
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ActivityAssistanceitemdetailData.class);
            noPayDetailAssert();
        }

    }

    @Test(description = "助力免单详情")
    public void payActivityAssistanceitemdetail() {
        genDetail(SqlDetail.getParamValue(2, "payActivityId"));
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ActivityAssistanceitemdetailData.class);
            payDetailAssert();
        }

    }

    private void payDetailAssert() {
        detailAssertTest(2222, "activity_price", model.activity_price);
        detailAssertTest(6, "booster_num", model.booster_num);

    }


    private void noPayDetailAssert() {
        detailAssertTest(139, "activity_id", model.activity_id);
        detailAssertTest(34535, "sku_id", model.sku_id);
        detailAssertTest("http://img2.haoshiqi.net/ma83cfe38517bb7812d3562f7d1486f3e1.jpg?imageView2/0/w/840/h/840/q/70", "pics.get(0)", model.pics.get(0));
        detailAssertTest("http://img2.haoshiqi.net/ma3cb8313f7b965464f25b142d28218c1e.jpg?imageView2/0/w/840/h/840/q/70", "pics.get(1)", model.pics.get(1));
        detailAssertTest("接口自动化测试专用助力免单 100g", "name", model.name);
        detailAssertTest("接口自动化测试专用助力免单 （勿动）", "activity_title", model.activity_title);
        detailAssertTest("活动规则", "activity_rule", model.activity_rule);
        detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(0).icon", model.labels.get(0).icon);
        detailAssertTest("正品保证", "labels.get(0).text", model.labels.get(0).text);
        detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=1", "labels.get(0).link", model.labels.get(0).link);
//        detailAssertTest("PICC承保", "labels.get(1).text", model.labels.get(1).text);
//        detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=2", "labels.get(1).link", model.labels.get(1).link);
//        detailAssertTest("48小时内发货", "labels.get(2).text", model.labels.get(2).text);
//        detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=3", "labels.get(2).link", model.labels.get(2).link);
//        detailAssertTest("正品保证", "labels.get(3).text", model.labels.get(3).text);
//        detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=4", "labels.get(3).link", model.labels.get(3).link);

        detailAssertTest(1, "status", model.status);
        detailAssertTest(2, "activity_status", model.activity_status);
        detailAssertTest(0, "activity_price", model.activity_price);
        detailAssertTest(9999, "single_price", model.single_price);
        detailAssertTest(1559544600, "start_time", model.start_time);
        detailAssertTest(2147483647, "end_time", model.end_time);
        detailAssertTest(1, "booster_num", model.booster_num);
        detailAssertTest(32767, "join_times_limit", model.join_times_limit);
        detailAssertTest(true, "can_delivery", model.can_delivery);
        detailAssertTest("", "udesk_merchant_id", model.udesk_merchant_id);
        detailAssertTest("http://img2.haoshiqi.net/freeMail@3x.png", "promotions.get(0).icon", model.promotions.get(0).icon);
        detailAssertTest("本商品满1件包邮", "promotions.get(0).text", model.promotions.get(0).text);
        detailAssertTest(28745, "product_id", model.product_id);
        detailAssertTest(2, "is_noticed", model.is_noticed);
        detailAssertTest(1, "can_buy", model.can_buy);
        detailAssertTest("规格", "attrs.get(0).name", model.attrs.get(0).name);
        detailAssertTest("100g", "attrs.get(0).value", model.attrs.get(0).value);
        detailAssertTest("保质期", "attrs.get(1).name", model.attrs.get(1).name);
        detailAssertTest("2000/01/01生产-2030/07/01到期", "attrs.get(1).value", model.attrs.get(1).value);
        detailAssertTest("1909065600", "batch", model.batch);


    }
}
