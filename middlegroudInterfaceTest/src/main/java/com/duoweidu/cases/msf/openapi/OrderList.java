package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.OrderListData;
import org.testng.annotations.Test;

public class OrderList extends MsfInterfaceTest {

    private OrderListData model;

    @Test(dependsOnGroups = "loginTrue",description = "订单列表接口")
    public void orderList() {
        setUrl("order.list.uri");
        param = "page_num=1&page_limit=20";
        process(true,true);
        model = sparseJson(OrderListData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).activity_id", model.list.get(i).activity_id);
            assertNotEmpty("list.get(i).activity_snapshot_id", model.list.get(i).activity_snapshot_id);
            assertNotEmpty("list.get(i).item_snapshot_id", model.list.get(i).item_snapshot_id);
            assertNotEmpty("list.get(i).branch_name", model.list.get(i).branch_name);
            assertNotEmpty("list.get(i).amount", model.list.get(i).amount);
            assertNotEmpty("list.get(i).expire_time", model.list.get(i).expire_time);
            assertNotEmpty("list.get(i).redeem_time", model.list.get(i).redeem_time);
            assertNotNull("list.get(i).status", model.list.get(i).status);
            assertNotNull("list.get(i).article_id", model.list.get(i).article_id);
            assertNotEmpty("list.get(i).item_id", model.list.get(i).item_id);
            assertNotEmpty("list.get(i).item_name", model.list.get(i).item_name);
            assertNotEmpty("list.get(i).item_pic", model.list.get(i).item_pic);
            assertNotEmpty("list.get(i).article_status", model.list.get(i).article_status);
            assertNotNull("list.get(i).video_id", model.list.get(i).video_id);

        }
    }
}
