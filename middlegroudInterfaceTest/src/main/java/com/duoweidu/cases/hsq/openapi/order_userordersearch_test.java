package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.OrderUserordersearchData;
import org.testng.annotations.Test;

public class order_userordersearch_test extends HsqInterfaceTest {

    private OrderUserordersearchData model;

    @Test(dependsOnGroups = "loginTrue",description = "订单搜索")
    public void order_userordersearch_true() {
        setUrl("order.userordersearch.uri");
        param = "&q=测试&pageLimit=20&pageNum=1";
        process(true,true);
        model = sparseJson(OrderUserordersearchData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).user_id", model.list.get(i).user_id);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).status", model.list.get(i).status);
            detailAssertTest("list.get(i).delivery_status", model.list.get(i).delivery_status);
            detailAssertTest("list.get(i).comment_status", model.list.get(i).comment_status);
//            detailAssertTest("list.get(i).merchant_discount", model.list.get(i).merchant_discount);
//            detailAssertTest("list.get(i).platform_discount", model.list.get(i).platform_discount);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
//            detailAssertTest("list.get(i).pay_price", model.list.get(i).pay_price);
//            detailAssertTest("list.get(i).pay_id", model.list.get(i).pay_id);
            detailAssertTest("list.get(i).need_pay_price", model.list.get(i).need_pay_price);
//            detailAssertTest("list.get(i).discount_price", model.list.get(i).discount_price);
//            detailAssertTest("list.get(i).delivery_price", model.list.get(i).delivery_price);
            detailAssertTest("list.get(i).total_price", model.list.get(i).total_price);
            detailAssertTest("list.get(i).total_amount", model.list.get(i).total_amount);
//            detailAssertTest("list.get(i).pay_time", model.list.get(i).pay_time);
//            detailAssertTest("list.get(i).delivery_time", model.list.get(i).delivery_time);
//            detailAssertTest("list.get(i).confirm_time", model.list.get(i).confirm_time);
            detailAssertTest("list.get(i).address_id", model.list.get(i).address_id);
            detailAssertTest("list.get(i).delivery_type", model.list.get(i).delivery_type);
            detailAssertTest("list.get(i).delivery_fee_way", model.list.get(i).delivery_fee_way);
//            detailAssertTest("list.get(i).is_delivery_free", model.list.get(i).is_delivery_free);
//            detailAssertTest("list.get(i).note", model.list.get(i).note);
            detailAssertTest("list.get(i).delivery_province", model.list.get(i).delivery_province);
            detailAssertTest("list.get(i).invoice_type", model.list.get(i).invoice_type);
//            detailAssertTest("list.get(i).invoice_title", model.list.get(i).invoice_title);
            detailAssertTest("list.get(i).delivery_city", model.list.get(i).delivery_city);
            detailAssertTest("list.get(i).delivery_district", model.list.get(i).delivery_district);
            detailAssertTest("list.get(i).delivery_detail_address", model.list.get(i).delivery_detail_address);
            detailAssertTest("list.get(i).consignee", model.list.get(i).consignee);
            detailAssertTest("list.get(i).consignee_phone", model.list.get(i).consignee_phone);
            detailAssertTest("list.get(i).created_at", model.list.get(i).created_at);
            detailAssertTest("list.get(i).updated_at", model.list.get(i).updated_at);
            detailAssertTest("list.get(i).order_type", model.list.get(i).order_type);
//            detailAssertTest("list.get(i).pin_activities_id", model.list.get(i).pin_activities_id);
//            detailAssertTest("list.get(i).pin_event_id", model.list.get(i).pin_event_id);
//            detailAssertTest("list.get(i).point_payment_id", model.list.get(i).point_payment_id);
//            detailAssertTest("list.get(i).payways", model.list.get(i).payways);
//            detailAssertTest("list.get(i).pay_info", model.list.get(i).pay_info);
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
                detailAssertTest("list.get(i).skuList.get(j).last_update", model.list.get(i).skuList.get(j).last_update);
//                detailAssertTest("list.get(i).skuList.get(j).platform_discount", model.list.get(i).skuList.get(j).platform_discount);
//                detailAssertTest("list.get(i).skuList.get(j).merchant_discount", model.list.get(i).skuList.get(j).merchant_discount);
//                detailAssertTest("list.get(i).skuList.get(j).settlement_price", model.list.get(i).skuList.get(j).settlement_price);
                detailAssertTest("list.get(i).skuList.get(j).settlement_way", model.list.get(i).skuList.get(j).settlement_way);
//                detailAssertTest("list.get(i).skuList.get(j).confirm_time", model.list.get(i).skuList.get(j).confirm_time);
//                detailAssertTest("list.get(i).skuList.get(j).pin_activities_id", model.list.get(i).skuList.get(j).pin_activities_id);
//                detailAssertTest("list.get(i).skuList.get(j).pin_event_id", model.list.get(i).skuList.get(j).pin_event_id);
//                detailAssertTest("list.get(i).skuList.get(j).point", model.list.get(i).skuList.get(j).point);
                detailAssertTest("list.get(i).skuList.get(j).source_type", model.list.get(i).skuList.get(j).source_type);
//                detailAssertTest("list.get(i).skuList.get(j).saved_money", model.list.get(i).skuList.get(j).saved_money);
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
//                detailAssertTest("list.get(i).skuList.get(j).schema", model.list.get(i).skuList.get(j).schema);

            }
//            detailAssertTest("list.get(i).refundId", model.list.get(i).refundId);
//            detailAssertTest("list.get(i).refundStatusDesc", model.list.get(i).refundStatusDesc);
            detailAssertTest("list.get(i).merchantName", model.list.get(i).merchantName);
            detailAssertTest("list.get(i).merchantId", model.list.get(i).merchantId);
            detailAssertTest("list.get(i).orderId", model.list.get(i).orderId);
            detailAssertTest("list.get(i).deliveryWay", model.list.get(i).deliveryWay);
            detailAssertTest("list.get(i).sourceType", model.list.get(i).sourceType);
//            detailAssertTest("list.get(i).schema", model.list.get(i).schema);
            detailAssertTest("list.get(i).canCancel", model.list.get(i).canCancel);
            detailAssertTest("list.get(i).canRefund", model.list.get(i).canRefund);
            detailAssertTest("list.get(i).order_status", model.list.get(i).order_status);
            assertNotNull("list.get(i).statusCode", model.list.get(i).statusCode);
            detailAssertTest("list.get(i).canPay", model.list.get(i).canPay);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("skuIds", model.skuIds);

    }
}
