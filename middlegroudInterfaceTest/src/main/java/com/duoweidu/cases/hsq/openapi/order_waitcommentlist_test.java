package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.OrderGetuserordersData;
import org.testng.annotations.Test;

public class order_waitcommentlist_test extends HsqInterfaceTest {

    private OrderGetuserordersData model;

    @Test(dependsOnGroups = "loginTrue",description ="获取用户待评论订单")
    public void order_waitcommentlist_true() {
        setUrl("order.waitcommentlist.uri");
        process(true,false);
        model = sparseJson(OrderGetuserordersData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).status", model.list.get(i).status);
            detailAssertTest("list.get(i).comment_status", model.list.get(i).comment_status);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
            detailAssertTest("list.get(i).order_type", model.list.get(i).order_type);
//            detailAssertTest("list.get(i).refundId", model.list.get(i).refundId);
//            detailAssertTest("list.get(i).refundStatusDesc", model.list.get(i).refundStatusDesc);
            detailAssertTest("list.get(i).orderId", model.list.get(i).orderId);
            detailAssertTest("list.get(i).sourceType", model.list.get(i).sourceType);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
    }
}
