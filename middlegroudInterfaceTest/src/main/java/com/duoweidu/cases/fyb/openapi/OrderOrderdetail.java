package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.OrderOrderdetailData;
import org.testng.annotations.Test;

public class OrderOrderdetail extends FybInterfaceTest {

    private OrderOrderdetailData model;

    @Test(description = "订单详情")
    public void orderOrderdetail() {
        setUrl("order.orderdetail.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
        model = sparseJson(OrderOrderdetailData.class);
        detailAssert();
    }

    private void detailAssert() {
            assertNotEmpty("list.id", model.id);
            assertNotEmpty("user_id", model.user_id);
            assertNotEmpty("merchant_id", model.merchant_id);
            assertNotEmpty("status", model.status);
            assertNotEmpty("delivery_status", model.delivery_status);
            assertNotEmpty("comment_status", model.comment_status);
            assertNotEmpty("market_price", model.market_price);
            assertNotEmpty("total_price", model.total_price);
            assertNotEmpty("total_amount", model.total_amount);
            assertNotEmpty("address_id", model.address_id);
            assertNotEmpty("delivery_type", model.delivery_type);
            assertNotEmpty("delivery_fee_way", model.delivery_fee_way);
            assertNotEmpty("is_delivery_free", model.is_delivery_free);
            assertNotEmpty("delivery_province", model.delivery_province);
            assertNotEmpty("invoice_type", model.invoice_type);
            assertNotEmpty("delivery_city", model.delivery_city);
            assertNotEmpty("delivery_district", model.delivery_district);
            assertNotEmpty("delivery_detail_address", model.delivery_detail_address);
            assertNotEmpty("consignee", model.consignee);
            assertNotEmpty("consignee_phone", model.consignee_phone);
            assertNotEmpty("created_at", model.created_at);
            assertNotEmpty("updated_at", model.updated_at);
            assertNotEmpty("order_type", model.order_type);
            assertNotEmpty("premium_income", model.premium_income);
            assertNotEmpty("sham_total_price", model.sham_total_price);

            assertNotEmpty("merchantName", model.merchantName);
            assertNotEmpty("merchantId", model.merchantId);
            assertNotEmpty("orderId", model.orderId);
            assertNotEmpty("deliveryWay", model.deliveryWay);
            assertNotEmpty("sourceType", model.sourceType);
            assertNotEmpty("canRefund", model.canRefund);
            assertNotEmpty("canCancel", model.canCancel);
            assertNotEmpty("statusCode", model.statusCode);

            for (int j = 0; j < model.skuList.size(); j++) {
                assertNotEmpty("skuList.get(j).id", model.skuList.get(j).id);
                assertNotEmpty("skuList.get(j).user_id", model.skuList.get(j).user_id);
                assertNotEmpty("skuList.get(j).order_id", model.skuList.get(j).order_id);
                assertNotEmpty("skuList.get(j).product_id", model.skuList.get(j).product_id);
                assertNotEmpty("skuList.get(j).sku_id", model.skuList.get(j).sku_id);
                assertNotEmpty("skuList.get(j).sku_name", model.skuList.get(j).sku_name);
                assertNotEmpty("skuList.get(j).sku_thumbnail", model.skuList.get(j).sku_thumbnail);
                assertNotEmpty("skuList.get(j).unit_price", model.skuList.get(j).unit_price);
                assertNotEmpty("skuList.get(j).market_price", model.skuList.get(j).market_price);
                assertNotEmpty("skuList.get(j).amount", model.skuList.get(j).amount);
                assertNotEmpty("skuList.get(j).total_price", model.skuList.get(j).total_price);
                assertNotEmpty("skuList.get(j).status", model.skuList.get(j).status);
                assertNotEmpty("skuList.get(j).comment_status", model.skuList.get(j).comment_status);
                assertNotEmpty("skuList.get(j).created_at", model.skuList.get(j).created_at);
                assertNotEmpty("skuList.get(j).updated_at", model.skuList.get(j).updated_at);
                assertNotEmpty("skuList.get(j).last_update", model.skuList.get(j).last_update);
                assertNotEmpty("skuList.get(j).settlement_way", model.skuList.get(j).settlement_way);
                assertNotEmpty("skuList.get(j).source_type", model.skuList.get(j).source_type);
                assertNotEmpty("skuList.get(j).skuId", model.skuList.get(j).skuId);
                assertNotEmpty("skuList.get(j).orderId", model.skuList.get(j).orderId);
                assertNotEmpty("skuList.get(j).userId", model.skuList.get(j).userId);
                assertNotEmpty("skuList.get(j).name", model.skuList.get(j).name);
                assertNotEmpty("skuList.get(j).skuThumbnail", model.skuList.get(j).skuThumbnail);
                assertNotEmpty("skuList.get(j).productId", model.skuList.get(j).productId);

                for (int k = 0; k < model.skuList.get(j).attribute_tags.size(); k++) {
                    assertNotEmpty("skuList.get(j).attribute_tags.get(k).name", model.skuList.get(j).attribute_tags.get(k).name);
                    assertNotEmpty("skuList.get(j).attribute_tags.get(k).value", model.skuList.get(j).attribute_tags.get(k).value);

                }

            }
            
    }
}
