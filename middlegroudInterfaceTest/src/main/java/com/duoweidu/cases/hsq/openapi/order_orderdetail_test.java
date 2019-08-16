package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderOrderdetailData;
import org.testng.annotations.Test;

public class order_orderdetail_test extends HsqInterfaceTest {

    private OrderOrderdetailData model;

    @Test(dependsOnGroups = "loginTrue",description = "订单详情（拼团）")
    public void order_orderdetail_pintuanTrue() {
        setUrl("order.orderdetail.uri");
        param = "orderId=" + SqlDetail.getInstance().getParamValue("orderId");
        process(true,false);
        model = sparseJson(OrderOrderdetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("merchant_id", model.merchant_id);
        detailAssertTest("status", model.status);
        detailAssertTest("delivery_status", model.delivery_status);
        detailAssertTest("comment_status", model.comment_status);
//        detailAssertTest("merchant_discount", model.merchant_discount);
//        detailAssertTest("platform_discount", model.platform_discount);
        detailAssertTest("market_price", model.market_price);
        detailAssertTest("pay_price", model.pay_price);
        detailAssertTest("pay_id", model.pay_id);
        detailAssertTest("need_pay_price", model.need_pay_price);
//        detailAssertTest("discount_price", model.discount_price);
//        detailAssertTest("delivery_price", model.delivery_price);
        detailAssertTest("total_price", model.total_price);
        detailAssertTest("total_amount", model.total_amount);
        detailAssertTest("pay_time", model.pay_time);
//        detailAssertTest("delivery_time", model.delivery_time);
//        detailAssertTest("confirm_time", model.confirm_time);
        detailAssertTest("address_id", model.address_id);
        detailAssertTest("delivery_type", model.delivery_type);
        detailAssertTest("delivery_fee_way", model.delivery_fee_way);
        detailAssertTest("is_delivery_free", model.is_delivery_free);
//        detailAssertTest("note", model.note);
        detailAssertTest("delivery_province", model.delivery_province);
        detailAssertTest("invoice_type", model.invoice_type);
//        detailAssertTest("invoice_title", model.invoice_title);
        detailAssertTest("delivery_city", model.delivery_city);
        detailAssertTest("delivery_district", model.delivery_district);
        detailAssertTest("delivery_detail_address", model.delivery_detail_address);
        detailAssertTest("consignee", model.consignee);
        detailAssertTest("consignee_phone", model.consignee_phone);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest("order_type", model.order_type);
        detailAssertTest("pin_activities_id", model.pin_activities_id);
        detailAssertTest("pin_event_id", model.pin_event_id);
//        detailAssertTest("point_payment_id", model.point_payment_id);
//        detailAssertTest("payways", model.payways);
        detailAssertTest("pay_info", model.pay_info);
        detailAssertTest("payment_method", model.payment_method);
        detailAssertTest("third_party_no", model.third_party_no);
        detailAssertTest("saved_money", model.saved_money);
//        detailAssertTest("solicitation_time", model.solicitation_time);
//        detailAssertTest("deductible_amount", model.deductible_amount);
//        detailAssertTest("premium_income", model.premium_income);
//        detailAssertTest("sham_total_price", model.sham_total_price);
//        detailAssertTest("merchant_order_note", model.merchant_order_note);
//        detailAssertTest("spm", model.spm);
        detailAssertTest("expire_ack_time", model.expire_ack_time);
//        detailAssertTest("cps_name", model.cps_name);
        for (int j = 0; j < model.skuList.size(); j++) {
            detailAssertTest("skuList.get(j).id", model.skuList.get(j).id);
            detailAssertTest("skuList.get(j).user_id", model.skuList.get(j).user_id);
            detailAssertTest("skuList.get(j).order_id", model.skuList.get(j).order_id);
            detailAssertTest("skuList.get(j).product_id", model.skuList.get(j).product_id);
            detailAssertTest("skuList.get(j).sku_id", model.skuList.get(j).sku_id);
//                detailAssertTest("skuList.get(j).bu_sku_id", model.skuList.get(j).bu_sku_id);
            detailAssertTest("skuList.get(j).sku_name", model.skuList.get(j).sku_name);
            detailAssertTest("skuList.get(j).sku_thumbnail", model.skuList.get(j).sku_thumbnail);
            detailAssertTest("skuList.get(j).unit_price", model.skuList.get(j).unit_price);
            detailAssertTest("skuList.get(j).market_price", model.skuList.get(j).market_price);
            detailAssertTest("skuList.get(j).amount", model.skuList.get(j).amount);
            detailAssertTest("skuList.get(j).total_price", model.skuList.get(j).total_price);
//                detailAssertTest("skuList.get(j).discount_price", model.skuList.get(j).discount_price);
//                detailAssertTest("skuList.get(j).pay_price", model.list.get(i).skuList.get(j).pay_price);
            if (model.skuList.get(j).attribute_tags.size() > 0) {
                for (int k = 0; k < model.skuList.get(j).attribute_tags.size(); k++) {
                    detailAssertTest("skuList.get(j).attribute_tags.get(j).name", model.skuList.get(j).attribute_tags.get(j).name);
                    detailAssertTest("skuList.get(j).attribute_tags.get(j).value", model.skuList.get(j).attribute_tags.get(j).value);
                }
            }
            detailAssertTest("skuList.get(j).status", model.skuList.get(j).status);
            detailAssertTest("skuList.get(j).comment_status", model.skuList.get(j).comment_status);
//                detailAssertTest("skuList.get(j).is_free", model.skuList.get(j).is_free);
            detailAssertTest("skuList.get(j).created_at", model.skuList.get(j).created_at);
            detailAssertTest("skuList.get(j).updated_at", model.skuList.get(j).updated_at);
            detailAssertTest("skuList.get(j).last_update", model.skuList.get(j).last_update);
//                detailAssertTest("skuList.get(j).platform_discount", model.skuList.get(j).platform_discount);
//                detailAssertTest("skuList.get(j).merchant_discount", model.skuList.get(j).merchant_discount);
            detailAssertTest("skuList.get(j).settlement_price", model.skuList.get(j).settlement_price);
            detailAssertTest("skuList.get(j).settlement_way", model.skuList.get(j).settlement_way);
//                detailAssertTest("skuList.get(j).confirm_time", model.skuList.get(j).confirm_time);
//                detailAssertTest("skuList.get(j).pin_activities_id", model.skuList.get(j).pin_activities_id);
//                detailAssertTest("skuList.get(j).pin_event_id", model.skuList.get(j).pin_event_id);
//                detailAssertTest("skuList.get(j).point", model.skuList.get(j).point);
            detailAssertTest("skuList.get(j).source_type", model.skuList.get(j).source_type);
            detailAssertTest("skuList.get(j).saved_money", model.skuList.get(j).saved_money);
//                detailAssertTest("skuList.get(j).refundInfo", model.skuList.get(j).refundInfo);
            detailAssertTest("skuList.get(j).skuId", model.skuList.get(j).skuId);
            detailAssertTest("skuList.get(j).orderId", model.skuList.get(j).orderId);
            detailAssertTest("skuList.get(j).userId", model.skuList.get(j).userId);
            detailAssertTest("skuList.get(j).name", model.skuList.get(j).name);
            for (int k = 0; k < model.skuList.get(j).attrs.size(); k++) {
                detailAssertTest("skuList.get(j).attrs.get(k).name", model.skuList.get(j).attrs.get(k).name);
                detailAssertTest("skuList.get(j).attrs.get(k).value", model.skuList.get(j).attrs.get(k).value);
            }
//                detailAssertTest("skuList.get(j).attrs_desc", model.skuList.get(j).attrs_desc);
//                detailAssertTest("skuList.get(j).refundStatusDesc", model.skuList.get(j).refundStatusDesc);
            detailAssertTest("skuList.get(j).subCanRefund", model.skuList.get(j).subCanRefund);
            detailAssertTest("skuList.get(j).skuThumbnail", model.skuList.get(j).skuThumbnail);
            detailAssertTest("skuList.get(j).productId", model.skuList.get(j).productId);
            detailAssertTest("skuList.get(j).schema", model.skuList.get(j).schema);

        }

        detailAssertTest("coupleTime", model.coupleTime);
        detailAssertTest("coupleStatus", model.coupleStatus);
//        detailAssertTest("restCount", model.restCount);
//        detailAssertTest("pinEventId", model.pinEventId);
        detailAssertTest("orderType", model.orderType);
        detailAssertTest("pinStatusDesc", model.pinStatusDesc);
//        detailAssertTest("pinStatusLink", model.pinStatusLink);
        detailAssertTest("isOwner", model.isOwner);
        detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest("shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
        detailAssertTest("shareInfo.wechat.pagePath", model.shareInfo.wechat.pagePath);
        detailAssertTest("shareInfo.wechat.userName", model.shareInfo.wechat.userName);
        detailAssertTest("shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("model.shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("model.shareInfo.wechat.content", model.shareInfo.wechat.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
        detailAssertTest("model.shareInfo.alipay.link", model.shareInfo.alipay.link);
        detailAssertTest("model.shareInfo.alipay.content", model.shareInfo.alipay.content);
        detailAssertTest("merchantName", model.merchantName);
//        detailAssertTest("udesk_merchant_id", model.udesk_merchant_id);
        detailAssertTest("serviceTel", model.serviceTel);
        detailAssertTest("merchantId", model.merchantId);
        detailAssertTest("orderId", model.orderId);
        detailAssertTest("productsPrice", model.productsPrice);
        detailAssertTest("refundId", model.refundId);
        detailAssertTest("canRefund", model.canRefund);
        detailAssertTest("deliveryWay", model.deliveryWay);
        detailAssertTest("sourceType", model.sourceType);
        detailAssertTest("schema", model.schema);
        detailAssertTest("canCancel", model.canCancel);
        detailAssertTest("statusCode", model.statusCode);
        detailAssertTest("canViewDelivery", model.canViewDelivery);
        detailAssertTest("statusLogo", model.statusLogo);
        detailAssertTest("stepList", model.stepList);

    }
}

