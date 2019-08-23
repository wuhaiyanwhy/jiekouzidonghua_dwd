package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.OrderOrderdetailData;
import org.testng.annotations.Test;


public class OrderOrderdetail extends JszInterfaceTest {

    private OrderOrderdetailData model;

    @Test(description = "订单详情")
    public void orderOrderdetail() {
        setUrl("order.orderlist.uri");
        param = "activityId=" + SqlDetail.getInstance().getParamValue("activityId");
        process(true, false);
        model = sparseJson(OrderOrderdetailData.class);
        detailAssert();
    }

    private void detailAssert(){
        for (int i = 0; i<model.list.size(); i++){
            detailAssertTest("id",model.list.get(i).id);
            detailAssertTest("user_id",model.list.get(i).user_id);
//            detailAssertTest("commission_user_id",model.list.get(i).commission_user_id);
            detailAssertTest("activity_id",model.list.get(i).activity_id);
            detailAssertTest("branch_id",model.list.get(i).branch_id);
            detailAssertTest("item_id",model.list.get(i).item_id);
            detailAssertTest("amount",model.list.get(i).amount);
            detailAssertTest("pay_amount",model.list.get(i).pay_amount);
//            detailAssertTest("commission_amount",model.list.get(i).commission_amount);
            detailAssertTest("redeem_time",model.list.get(i).redeem_time);
            detailAssertTest("start_time",model.list.get(i).start_time);
            detailAssertTest("expire_time",model.list.get(i).expire_time);
            detailAssertTest("pay_at",model.list.get(i).pay_at);
            detailAssertTest("refunded_at",model.list.get(i).refunded_at);
            detailAssertTest("refund_status",model.list.get(i).refund_status);
            detailAssertTest("row_status",model.list.get(i).row_status);
            detailAssertTest("created_at",model.list.get(i).created_at);
            detailAssertTest("branch_name",model.list.get(i).branch_name);
            detailAssertTest("status",model.list.get(i).status);
            detailAssertTest("status_text",model.list.get(i).status_text);
            detailAssertTest("item_name",model.list.get(i).item_name);
            detailAssertTest("item_image",model.list.get(i).item_image);
            detailAssertTest("sale_price",model.list.get(i).sale_price);
            detailAssertTest("market_price",model.list.get(i).market_price);
            detailAssertTest("expire_timestamp",model.list.get(i).expire_timestamp);
        }
    }
}
