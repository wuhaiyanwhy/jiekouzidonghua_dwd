package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserCouponlistData;
import org.testng.annotations.Test;


public class user_couponlist_test extends HsqInterfaceTest {

    private UserCouponlistData model;

    private void genCouponlist(int type, boolean isList) {
        setUrl("user.couponlist.uri");
        param = "type=" + type;
        process(true, isList);
        model = sparseJson(UserCouponlistData.class);
    }

    @Test(dependsOnGroups = "loginTrue",description ="获取用户优惠券(未使用)")
    public void user_couponlist_weishiyongTrue() {
        genCouponlist(1, false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="获取用户优惠券(已过期)")
    public void user_couponlist_yiguoqiTrue() {
        genCouponlist(2, true);
        detailAssert();
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(已使用)")
    public void user_couponlist_yishiyongTrue() {
        genCouponlist(3, true);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).coupon_id", model.list.get(i).coupon_id);
            detailAssertTest("list.get(i).coupon_code", model.list.get(i).coupon_code);
            detailAssertTest("list.get(i).range_type", model.list.get(i).range_type);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).title", model.list.get(i).title);
            detailAssertTest("list.get(i).sub_title", model.list.get(i).sub_title);
            detailAssertTest("list.get(i).usage_title", model.list.get(i).usage_title);
            detailAssertTest("list.get(i).value", model.list.get(i).value);
            detailAssertTest("list.get(i).is_at_least", model.list.get(i).is_at_least);
            detailAssertTest("list.get(i).at_least", model.list.get(i).at_least);
            detailAssertTest("list.get(i).start_at", model.list.get(i).start_at);
            detailAssertTest("list.get(i).end_at", model.list.get(i).end_at);
            detailAssertTest("list.get(i).usage_desc", model.list.get(i).usage_desc);
            detailAssertTest("list.get(i).status", String.valueOf(model.list.get(i).status));
            detailAssertTest("list.get(i).is_expired", String.valueOf(model.list.get(i).is_expired));
            detailAssertTest("list.get(i).is_used", String.valueOf(model.list.get(i).is_used));
            detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
        }
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("usageUrl", model.usageUrl);
        detailAssertTest("couponCnt.avaliableCnt", model.couponCnt.avaliableCnt);
        detailAssertTest("couponCnt.expiredCnt", model.couponCnt.expiredCnt);
        detailAssertTest("couponCnt.usedCnt", model.couponCnt.usedCnt);

    }

}
