package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.OrderGetuserordersData;
import org.testng.annotations.Test;

public class OrderGetuserorders extends FybInterfaceTest {

    private OrderGetuserordersData model;

    @Test(description = "用户订单列表")
    public void orderGetuserorders() {
        setUrl("order.getuserorders.uri");
        param = "type=0";
        process(true,true);
        model = sparseJson(OrderGetuserordersData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("totalCnt", model.totalCnt);
        assertNotEmpty("totalPage", model.totalPage);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).merchant_id", model.list.get(i).merchant_id);
            assertNotEmpty("list.get(i).status", model.list.get(i).status);
            assertNotEmpty("list.get(i).delivery_status", model.list.get(i).delivery_status);
            assertNotEmpty("list.get(i).comment_status", model.list.get(i).comment_status);
            assertNotEmpty("list.get(i).market_price", model.list.get(i).market_price);
            assertNotEmpty("list.get(i).total_price", model.list.get(i).total_price);
            assertNotEmpty("list.get(i).total_amount", model.list.get(i).total_amount);
            assertNotEmpty("list.get(i).address_id", model.list.get(i).address_id);
            assertNotEmpty("list.get(i).delivery_type", model.list.get(i).delivery_type);
            assertNotEmpty("list.get(i).delivery_fee_way", model.list.get(i).delivery_fee_way);
            assertNotEmpty("list.get(i).is_delivery_free", model.list.get(i).is_delivery_free);
            assertNotEmpty("list.get(i).delivery_province", model.list.get(i).delivery_province);
            assertNotEmpty("list.get(i).invoice_type", model.list.get(i).invoice_type);
            assertNotEmpty("list.get(i).delivery_city", model.list.get(i).delivery_city);
            assertNotEmpty("list.get(i).delivery_district", model.list.get(i).delivery_district);
            assertNotEmpty("list.get(i).delivery_detail_address", model.list.get(i).delivery_detail_address);
            assertNotEmpty("list.get(i).consignee", model.list.get(i).consignee);
            assertNotEmpty("list.get(i).consignee_phone", model.list.get(i).consignee_phone);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
            assertNotEmpty("list.get(i).order_type", model.list.get(i).order_type);
            assertNotEmpty("list.get(i).merchantName", model.list.get(i).merchantName);
            assertNotEmpty("list.get(i).merchantId", model.list.get(i).merchantId);
            assertNotEmpty("list.get(i).orderId", model.list.get(i).orderId);
            assertNotEmpty("list.get(i).deliveryWay", model.list.get(i).deliveryWay);
            assertNotEmpty("list.get(i).sourceType", model.list.get(i).sourceType);
            assertNotEmpty("list.get(i).canRefund", model.list.get(i).canRefund);
            assertNotEmpty("list.get(i).canCancel", model.list.get(i).canCancel);
            assertNotEmpty("list.get(i).order_status", model.list.get(i).order_status);
            assertNotEmpty("list.get(i).statusCode", model.list.get(i).statusCode);
            assertNotEmpty("list.get(i).shareStatus", model.list.get(i).shareStatus);

            for (int j = 0; j < model.list.get(i).skuList.size(); j++) {
                assertNotEmpty("list.get(i).skuList.get(j).id", model.list.get(i).skuList.get(j).id);
                assertNotEmpty("list.get(i).skuList.get(j).user_id", model.list.get(i).skuList.get(j).user_id);
                assertNotEmpty("list.get(i).skuList.get(j).order_id", model.list.get(i).skuList.get(j).order_id);
                assertNotEmpty("list.get(i).skuList.get(j).product_id", model.list.get(i).skuList.get(j).product_id);
                assertNotEmpty("list.get(i).skuList.get(j).sku_id", model.list.get(i).skuList.get(j).sku_id);
                assertNotEmpty("list.get(i).skuList.get(j).sku_name", model.list.get(i).skuList.get(j).sku_name);
                assertNotEmpty("list.get(i).skuList.get(j).sku_thumbnail", model.list.get(i).skuList.get(j).sku_thumbnail);
                assertNotEmpty("list.get(i).skuList.get(j).unit_price", model.list.get(i).skuList.get(j).unit_price);
                assertNotEmpty("list.get(i).skuList.get(j).market_price", model.list.get(i).skuList.get(j).market_price);
                assertNotEmpty("list.get(i).skuList.get(j).amount", model.list.get(i).skuList.get(j).amount);
                assertNotEmpty("list.get(i).skuList.get(j).total_price", model.list.get(i).skuList.get(j).total_price);
                assertNotEmpty("list.get(i).skuList.get(j).status", model.list.get(i).skuList.get(j).status);
                assertNotEmpty("list.get(i).skuList.get(j).comment_status", model.list.get(i).skuList.get(j).comment_status);
                assertNotEmpty("list.get(i).skuList.get(j).created_at", model.list.get(i).skuList.get(j).created_at);
                assertNotEmpty("list.get(i).skuList.get(j).updated_at", model.list.get(i).skuList.get(j).updated_at);
                assertNotEmpty("list.get(i).skuList.get(j).last_update", model.list.get(i).skuList.get(j).last_update);
                assertNotEmpty("list.get(i).skuList.get(j).settlement_way", model.list.get(i).skuList.get(j).settlement_way);
                assertNotEmpty("list.get(i).skuList.get(j).source_type", model.list.get(i).skuList.get(j).source_type);
                assertNotEmpty("list.get(i).skuList.get(j).skuId", model.list.get(i).skuList.get(j).skuId);
                assertNotEmpty("list.get(i).skuList.get(j).orderId", model.list.get(i).skuList.get(j).orderId);
                assertNotEmpty("list.get(i).skuList.get(j).userId", model.list.get(i).skuList.get(j).userId);
                assertNotEmpty("list.get(i).skuList.get(j).name", model.list.get(i).skuList.get(j).name);
                assertNotEmpty("list.get(i).skuList.get(j).skuThumbnail", model.list.get(i).skuList.get(j).skuThumbnail);
                assertNotEmpty("list.get(i).skuList.get(j).productId", model.list.get(i).skuList.get(j).productId);

                for (int k = 0; k < model.list.get(i).skuList.get(j).attribute_tags.size(); k++) {
                    assertNotEmpty("list.get(i).skuList.get(j).attribute_tags.get(k).name", model.list.get(i).skuList.get(j).attribute_tags.get(k).name);
                    assertNotEmpty("list.get(i).skuList.get(j).attribute_tags.get(k).value", model.list.get(i).skuList.get(j).attribute_tags.get(k).value);

                }

            }


        }
    }
}
