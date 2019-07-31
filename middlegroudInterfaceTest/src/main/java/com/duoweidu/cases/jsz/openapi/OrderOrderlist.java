package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.model.jsz.OrderOrderdetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;


public class OrderOrderlist extends JszInterfaceTest {

    private OrderOrderdetailData model;

    public void orderOrderlist(String status, boolean isList) {
        setUrl("order.orderlist.uri");
        param = "status="+ status;
        process(true, isList);
        model = sparseJson(OrderOrderdetailData.class);
        detailAssert();
    }

    @Test(dependsOnGroups = "OrderCreateorder",description = "1全部订单")
    public void orderOrderlist1() {
        if (ConfigFileUrl.getEnv().equals("beta")) {
            orderOrderlist("1", true);
        }
        else if (ConfigFileUrl.getEnv().equals("prod")) {
            orderOrderlist("1", false);
        }

    }

    @Test(dependsOnGroups = "OrderPayorder",groups = "orderOrderlist2",description = "2待付款")
    public void orderOrderlist2() {
        if (ConfigFileUrl.getEnv().equals("beta")) {
            orderOrderlist("2", true);
        }
        else if (ConfigFileUrl.getEnv().equals("prod")) {
            orderOrderlist("2", false);
        }
    }

    @Test(description = "3待使用")
    public void orderOrderlist3() {
        orderOrderlist("3",false);
    }

    @Test(description = "4已使用")
    public void orderOrderlist4() {
        orderOrderlist("4",false);
    }

    @Test(description = "5已过期")
    public void orderOrderlist5() {
        orderOrderlist("5",false);
    }

    @Test(description = "6已取消")
    public void orderOrderlist6() {
        orderOrderlist("6",false);
    }

    @Test(description = "7已退款")
    public void orderOrderlist7() {
        orderOrderlist("7",false);
    }


    private void detailAssert(){
        for (int i = 0; i<model.list.size(); i++) {
            detailAssertTest("id", model.list.get(i).id);
            detailAssertTest("user_id", model.list.get(i).user_id);
//            detailAssertTest("commission_user_id", model.list.get(i).commission_user_id);
            detailAssertTest("activity_id", model.list.get(i).activity_id);
            detailAssertTest("branch_id", model.list.get(i).branch_id);
//            detailAssertTest("item_id", model.list.get(i).item_id);
            detailAssertTest("amount", model.list.get(i).amount);
            detailAssertTest("pay_amount", model.list.get(i).pay_amount);
//            detailAssertTest("commission_amount", model.list.get(i).commission_amount);
            detailAssertTest("redeem_time", model.list.get(i).redeem_time);
            detailAssertTest("start_time", model.list.get(i).start_time);
            detailAssertTest("expire_time", model.list.get(i).expire_time);
            detailAssertTest("pay_at", model.list.get(i).pay_at);
            detailAssertTest("refunded_at", model.list.get(i).refunded_at);
            detailAssertTest("refund_status", model.list.get(i).refund_status);
            detailAssertTest("row_status", model.list.get(i).row_status);
            detailAssertTest("created_at", model.list.get(i).created_at);
            detailAssertTest("branch_name", model.list.get(i).branch_name);
            detailAssertTest("status", model.list.get(i).status);
            detailAssertTest("status_text", model.list.get(i).status_text);
            detailAssertTest("item_name", model.list.get(i).item_name);
            detailAssertTest("item_image", model.list.get(i).item_image);
            detailAssertTest("sale_price", model.list.get(i).sale_price);
            detailAssertTest("market_price", model.list.get(i).market_price);
            detailAssertTest("expire_timestamp", model.list.get(i).expire_timestamp);
        }
    }
}

