package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.OrderUserserviceordersData;
import org.testng.annotations.Test;

public class order_userserviceorders_test extends HsqInterfaceTest {

    private OrderUserserviceordersData model;

    @Test(dependsOnGroups = "loginTrue",description ="获取用户售后订单")
    public void order_userserviceorders_true() {
        setUrl("order.userserviceorders.uri");
        process(true,false);
        model = sparseJson(OrderUserserviceordersData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).status", model.list.get(i).status);
            detailAssertTest("list.get(i).delivery_status", model.list.get(i).delivery_status);
            detailAssertTest("list.get(i).need_pay_price", model.list.get(i).need_pay_price);
            detailAssertTest("list.get(i).consignee_phone", model.list.get(i).consignee_phone);
            detailAssertTest("list.get(i).order_type", model.list.get(i).order_type);
            detailAssertTest("list.get(i).skuList", model.list.get(i).skuList);
            for (int j = 0; j < model.list.get(i).skuList.size(); j++) {
                detailAssertTest("list.get(i).skuList.get(j).id", model.list.get(i).skuList.get(j).id);
                detailAssertTest("list.get(i).skuList.get(j).user_id", model.list.get(i).skuList.get(j).user_id);
                detailAssertTest("list.get(i).skuList.get(j).order_id", model.list.get(i).skuList.get(j).order_id);
                detailAssertTest("list.get(i).skuList.get(j).product_id", model.list.get(i).skuList.get(j).product_id);
                detailAssertTest("list.get(i).skuList.get(j).sku_id", model.list.get(i).skuList.get(j).sku_id);
//                detailAssertTest("list.get(i).skuList.get(j).bu_sku_id", model.list.get(i).skuList.get(j).bu_sku_id);
                detailAssertTest("list.get(i).skuList.get(j).sku_name", model.list.get(i).skuList.get(j).sku_name);
                detailAssertTest("list.get(i).skuList.get(j).sku_thumbnail", model.list.get(i).skuList.get(j).sku_thumbnail);
                detailAssertTest("list.get(i).skuList.get(j).unit_price", model.list.get(i).skuList.get(j).unit_price);
                detailAssertTest("list.get(i).skuList.get(j).market_price", model.list.get(i).skuList.get(j).market_price);
                detailAssertTest("list.get(i).skuList.get(j).amount", model.list.get(i).skuList.get(j).amount);
                detailAssertTest("list.get(i).skuList.get(j).total_price", model.list.get(i).skuList.get(j).total_price);
//                detailAssertTest("list.get(i).skuList.get(j).discount_price", model.list.get(i).skuList.get(j).discount_price);
//                detailAssertTest("list.get(i).skuList.get(j).pay_price", model.list.get(i).skuList.get(j).pay_price);
                if (model.list.get(i).skuList.get(j).attribute_tags.size() > 0) {
                    for (int k = 0; k < model.list.get(i).skuList.get(j).attribute_tags.size(); k++) {
                        detailAssertTest("list.get(i).skuList.get(j).attribute_tags.get(j).name", model.list.get(i).skuList.get(j).attribute_tags.get(j).name);
                        detailAssertTest("list.get(i).skuList.get(j).attribute_tags.get(j).value", model.list.get(i).skuList.get(j).attribute_tags.get(j).value);
                    }
                }
                detailAssertTest("list.get(i).skuList.get(j).status", model.list.get(i).skuList.get(j).status);
                detailAssertTest("list.get(i).skuList.get(j).comment_status", model.list.get(i).skuList.get(j).comment_status);
//                detailAssertTest("list.get(i).skuList.get(j).is_free", model.list.get(i).skuList.get(j).is_free);
                detailAssertTest("list.get(i).skuList.get(j).created_at", model.list.get(i).skuList.get(j).created_at);
                detailAssertTest("list.get(i).skuList.get(j).updated_at", model.list.get(i).skuList.get(j).updated_at);
                detailAssertTest("list.get(i).skuList.get(j).settlement_price", model.list.get(i).skuList.get(j).settlement_price);
                detailAssertTest("list.get(i).skuList.get(j).settlement_way", model.list.get(i).skuList.get(j).settlement_way);
//                detailAssertTest("list.get(i).skuList.get(j).confirm_time", model.list.get(i).skuList.get(j).confirm_time);
//                detailAssertTest("list.get(i).skuList.get(j).pin_activities_id", model.list.get(i).skuList.get(j).pin_activities_id);
//                detailAssertTest("list.get(i).skuList.get(j).pin_event_id", model.list.get(i).skuList.get(j).pin_event_id);
//                detailAssertTest("list.get(i).skuList.get(j).point", model.list.get(i).skuList.get(j).point);
                detailAssertTest("list.get(i).skuList.get(j).source_type", model.list.get(i).skuList.get(j).source_type);
//                detailAssertTest("list.get(i).skuList.get(j).refundInfo", model.list.get(i).skuList.get(j).refundInfo);
                detailAssertTest("list.get(i).skuList.get(j).skuId", model.list.get(i).skuList.get(j).skuId);
                detailAssertTest("list.get(i).skuList.get(j).orderId", model.list.get(i).skuList.get(j).orderId);
                detailAssertTest("list.get(i).skuList.get(j).userId", model.list.get(i).skuList.get(j).userId);
                detailAssertTest("list.get(i).skuList.get(j).name", model.list.get(i).skuList.get(j).name);
                for (int k = 0; k < model.list.get(i).skuList.get(j).attrs.size(); k++) {
                    detailAssertTest("list.get(i).skuList.get(j).attrs.get(k).name", model.list.get(i).skuList.get(j).attrs.get(k).name);
                    detailAssertTest("list.get(i).skuList.get(j).attrs.get(k).value", model.list.get(i).skuList.get(j).attrs.get(k).value);
                }
//                detailAssertTest("list.get(i).skuList.get(j).attrs_desc", model.list.get(i).skuList.get(j).attrs_desc);
//                detailAssertTest("list.get(i).skuList.get(j).refundStatusDesc", model.list.get(i).skuList.get(j).refundStatusDesc);
                detailAssertTest("list.get(i).skuList.get(j).subCanRefund", model.list.get(i).skuList.get(j).subCanRefund);
                detailAssertTest("list.get(i).skuList.get(j).skuThumbnail", model.list.get(i).skuList.get(j).skuThumbnail);
                detailAssertTest("list.get(i).skuList.get(j).productId", model.list.get(i).skuList.get(j).productId);
                detailAssertTest("list.get(i).skuList.get(j).schema", model.list.get(i).skuList.get(j).schema);

            }
//            detailAssertTest("list.get(i).refundId", model.list.get(i).refundId);
//            detailAssertTest("list.get(i).refundStatusDesc", model.list.get(i).refundStatusDesc);
            detailAssertTest("list.get(i).merchantName", model.list.get(i).merchantName);
            detailAssertTest("list.get(i).merchantId", model.list.get(i).merchantId);
            detailAssertTest("list.get(i).orderId", model.list.get(i).orderId);
            detailAssertTest("list.get(i).sourceType", model.list.get(i).sourceType);
            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("subOrderIds", model.subOrderIds);
        detailAssertTest("orderIds", model.orderIds);


    }

}
