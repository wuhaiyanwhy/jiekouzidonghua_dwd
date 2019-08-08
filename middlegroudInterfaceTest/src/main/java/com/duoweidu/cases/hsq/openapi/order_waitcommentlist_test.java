package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.OrderGetuserordersData;
import com.duoweidu.model.hsq.OrderWaitcommentlistData;
import org.testng.annotations.Test;

public class order_waitcommentlist_test extends HsqInterfaceTest {

    private OrderWaitcommentlistData model;

    @Test(dependsOnGroups = "loginTrue",description ="获取用户待评论订单")
    public void order_waitcommentlist_true() {
        setUrl("order.waitcommentlist.uri");
        process(true,false);
        model = sparseJson(OrderWaitcommentlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).order_id", model.list.get(i).order_id);
            detailAssertTest("list.get(i).product_id", model.list.get(i).product_id);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
//            detailAssertTest("list.get(i).bu_sku_id", model.list.get(i).bu_sku_id);
            detailAssertTest("list.get(i).sku_name", model.list.get(i).sku_name);
            detailAssertTest("list.get(i).sku_thumbnail", model.list.get(i).sku_thumbnail);
            detailAssertTest("list.get(i).unit_price", model.list.get(i).unit_price);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
            detailAssertTest("list.get(i).amount", model.list.get(i).amount);
            detailAssertTest("list.get(i).total_price", model.list.get(i).total_price);
//            detailAssertTest("list.get(i).discount_price", model.list.get(i).discount_price);
//            detailAssertTest("list.get(i).pay_price", model.list.get(i).pay_price);
//            detailAssertTest("list.get(i).attribute_tags", model.list.get(i).attribute_tags);
            detailAssertTest("list.get(i).status", model.list.get(i).status);
            detailAssertTest("list.get(i).comment_status", model.list.get(i).comment_status);

//            detailAssertTest("list.get(i).is_free", model.list.get(i).is_free);
            detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
            detailAssertTest("list.get(i).updated_at", model.list.get(i).updated_at);
//            detailAssertTest("list.get(i).platform_discount", model.list.get(i).platform_discount);
//            detailAssertTest("list.get(i).merchant_discount", model.list.get(i).merchant_discount);
            detailAssertTest("list.get(i).settlement_price", model.list.get(i).settlement_price);
            detailAssertTest("list.get(i).settlement_way", model.list.get(i).settlement_way);
            detailAssertTest("list.get(i).confirm_time", model.list.get(i).confirm_time);
            detailAssertTest("list.get(i).pin_activities_id", model.list.get(i).pin_activities_id);
//            detailAssertTest("list.get(i).pin_event_id", model.list.get(i).pin_event_id);
//            detailAssertTest("list.get(i).point", model.list.get(i).point);
            detailAssertTest("list.get(i).source_type", model.list.get(i).source_type);
            detailAssertTest("list.get(i).order_type", model.list.get(i).order_type);
//            detailAssertTest("list.get(i).saved_money", model.list.get(i).saved_money);
            detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
            detailAssertTest("list.get(i).orderId", model.list.get(i).orderId);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).subOrderId", model.list.get(i).subOrderId);
            detailAssertTest("list.get(i).skuThumbnail", model.list.get(i).skuThumbnail);
//            detailAssertTest("list.get(i).attrs", model.list.get(i).attrs);
            detailAssertTest("list.get(i).orderType", model.list.get(i).orderType);
            detailAssertTest("list.get(i).pinActivitiesId", model.list.get(i).pinActivitiesId);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);

        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
    }
}
