package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderCheckpromotionData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class order_checkpromotion_test extends HsqInterfaceTest {

    private OrderCheckpromotionData model;

    @Test(dependsOnGroups = "loginTrue", description = "确认订单-选择优惠券")
    public void order_checkpromotion_true() {
        setUrl("order.checkpromotion.uri");
        try {
            param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue("pinActivitiesId") +
                    "&skusInfo=" + URLEncoder.encode("[\n" +
                    "  {\n" +
                    "    \"skuId\" : \"" + SqlDetail.getInstance().getParamValue("skuId") + "\",\n" +
                    "    \"amount\" : \"1\",\n" +
                    "    \"price\" : \"" + SqlDetail.getInstance().getParamValue("price") + "\"\n" +
                    "  }\n" +
                    "]", "GBK") +
                    "&orderType=2" +
                    "&couponCodes=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        process(false, false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(OrderCheckpromotionData.class);
            generalDetailAssert();
            //储存切换确认订单-选择优惠券，优惠券id和code码
            HsqOpenapiConfig.couponId = model.couponList.get(0).coupon_id;
            HsqOpenapiConfig.couponCode = model.couponList.get(0).coupon_code;

        }

    }

    public void generalDetailAssert() {
        detailAssertTest(2901, "couponList.get(0).coupon_id", model.couponList.get(0).coupon_id);
        detailAssertTest("ALL", "couponList.get(0).range_type", model.couponList.get(0).range_type);
        detailAssertTest(1, "couponList.get(0).is_at_least", model.couponList.get(0).is_at_least);
        detailAssertTest(700, "couponList.get(0).at_least", model.couponList.get(0).at_least);
        detailAssertTest(3, "couponList.get(0).type", model.couponList.get(0).type);
        detailAssertTest("满7减2", "couponList.get(0).title", model.couponList.get(0).title);
        detailAssertTest("全场满7元使用", "couponList.get(0).sub_title", model.couponList.get(0).sub_title);
        detailAssertTest(200, "couponList.get(0).value", model.couponList.get(0).value);
        detailAssertTest("全场通用", "couponList.get(0).usage_title", model.couponList.get(0).usage_title);
        detailAssertTest("不退款,不兑余额,不兑现金,不找零\\r\\n使用范围:全场使用", "couponList.get(0).usage_desc", model.couponList.get(0).usage_desc);
        detailAssertTest(0, "couponList.get(0).is_expired", model.couponList.get(0).is_expired);
        detailAssertTest(0, "couponList.get(0).is_used", model.couponList.get(0).is_used);
//        detailAssertTest(0, "couponList.get(0).used_at", model.couponList.get(0).used_at);
        detailAssertTest(false, "couponList.get(0).selected", model.couponList.get(0).selected);
        detailAssertTest(true, "couponList.get(0).canUse", model.couponList.get(0).canUse);
        detailAssertTest(0, "couponList.get(0).weight", model.couponList.get(0).weight);

    }
}
