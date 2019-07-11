package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.hsq.TradecenterOrderinfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class tradecenter_orderinfo_test extends HsqInterfaceTest {


    private TradecenterOrderinfoData model;

    @Test(description = "积分订单订单详情")
    public void tradecenter_orderinfo_true() {

        setUrl("tradecenter.orderinfo.uri");
        param = "token=" + SqlDetail.getParamValue("token") + "&orderId=" + SqlDetail.getParamValue("pointOrderId");
        process(false, false);

        model = sparseJson(TradecenterOrderinfoData.class);
        tradecenterOrderinfoAssert();
    }

    private void tradecenterOrderinfoAssert() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest("2163944807", "model.id", model.id);
            detailAssertTest(4, "model.status", model.status);
            detailAssertTest("红红", "model.consignee", model.consignee);
            detailAssertTest("", "model.note", model.note);
            detailAssertTest(3, "model.payways", model.payways);
            detailAssertTest("2163944807", "model.orderId", model.orderId);
            detailAssertTest(23391725, "model.userId", model.userId);
            detailAssertTest(0, "model.merchantId", model.merchantId);
            detailAssertTest(1902, "model.addressId", model.addressId);
            detailAssertTest(0, "model.pointPaymentId", model.pointPaymentId);
            detailAssertTest(0, "model.point_payment_id", model.point_payment_id);
            detailAssertTest(6, "model.orderType", model.orderType);
            detailAssertTest(1, "model.deliveryType", model.deliveryType);
            detailAssertTest(1, "model.invoiceType", model.invoiceType);
            detailAssertTest("", "model.invoiceTitle", model.invoiceTitle);
            detailAssertTest("130****6002", "model.consigneePhone", model.consigneePhone);
            detailAssertTest(1, "model.needPayPrice", model.needPayPrice);
            detailAssertTest(0, "model.payPrice", model.payPrice);
            detailAssertTest(1099, "model.totalPrice", model.totalPrice);
            detailAssertTest(0, "model.deliveryPrice", model.deliveryPrice);
            detailAssertTest(0, "model.merchantDiscount", model.merchantDiscount);
            detailAssertTest(0, "model.platformDiscount", model.platformDiscount);
            detailAssertTest(88, "model.totalPoint", model.totalPoint);
            detailAssertTest(1, "model.totalAmount", model.totalAmount);
            detailAssertTest(1, "model.deliveryStatus", model.deliveryStatus);
            detailAssertTest(1, "model.commentStatus", model.commentStatus);
            detailAssertTest("北京", "model.deliveryProvince", model.deliveryProvince);
            detailAssertTest("北京市", "model.deliveryCity", model.deliveryCity);
            detailAssertTest("东城区", "model.deliveryDistrict", model.deliveryDistrict);
            detailAssertTest("110101", "model.deliveryDetailAddress", model.deliveryDetailAddress);
            detailAssertTest(null, "model.payTime", model.payTime);
            detailAssertTest(0, "model.deliveryTime", model.deliveryTime);
            detailAssertTest(0, "model.confirmTime", model.confirmTime);
            detailAssertTest(1561014860, "model.createdAt", model.createdAt);
            detailAssertTest(1561014861, "model.updatedAt", model.updatedAt);
            detailAssertTest(0, "model.discountPrice", model.discountPrice);
            detailAssertTest(0, "model.saved_money", model.saved_money);
            detailAssertTest(0, "model.solicitation_time", model.solicitation_time);
            detailAssertTest(0, "model.deductible_amount", model.deductible_amount);
            detailAssertTest(0, "model.premium_income", model.premium_income);
            detailAssertTest(0, "model.sham_total_price", model.sham_total_price);
            detailAssertTest("", "model.merchant_order_note", model.merchant_order_note);
            detailAssertTest("", "model.cps_name", model.cps_name);

            detailAssertTest("model.skuList", model.skuList);

            for (int i = 0; i < model.skuList.size(); i++) {

                if (model.skuList.get(i).id.equals("16492967")) {

                    detailAssertTest(1, "model.skuList.amount", model.skuList.get(i).amount);
                    detailAssertTest(4, "model.skuList.status", model.skuList.get(i).status);
                    detailAssertTest(88, "list.get(i).skuList.point", model.skuList.get(i).point);
                    detailAssertTest("[{\"name\":\"\\u4e0b\\u5355\\u65f6\\u4fdd\\u8d28\\u671f\",\"value\":\"2018\\/04\\/01\\u751f\\u4ea7-2028\\/02\\/08\\u5230\\u671f\"}]", "model.skuList.attribute_tags", model.skuList.get(i).attribute_tags);
                    detailAssertTest(23391725, "model.skuList.userId", model.skuList.get(i).userId);
                    detailAssertTest("2163944807", "model.skuList.orderId", model.skuList.get(i).orderId);
                    detailAssertTest(25302, "model.skuList.productId", model.skuList.get(i).productId);
                    detailAssertTest(2669, "model.skuList.buSkuId", model.skuList.get(i).buSkuId);
                    detailAssertTest(28659, "model.skuList.skuId", model.skuList.get(i).skuId);
                    detailAssertTest("接口测试专用商品，勿动动", "model.skuList.skuName", model.skuList.get(i).skuName);
                    detailAssertTest("http://img2.haoshiqi.net/ma32483124920c8aea275a83545aa3b5aa.jpg?imageView2/0/w/200/h/200/q/70", "model.skuList.skuThumbnail", model.skuList.get(i).skuThumbnail);
                    detailAssertTest(5000, "model.skuList.marketPrice", model.skuList.get(i).marketPrice);
                    detailAssertTest(1099, "modelskuList.totalPrice", model.skuList.get(i).totalPrice);
                    detailAssertTest(0, "model.skuList.payPrice", model.skuList.get(i).payPrice);
                    detailAssertTest(1099, "model.skuList.unitPrice", model.skuList.get(i).unitPrice);
                    detailAssertTest(1, "model.skuList.commentStatus", model.skuList.get(i).commentStatus);
                    detailAssertTest(1561014860, "model.skuList.createdAt", model.skuList.get(i).createdAt);
                    detailAssertTest(1561014861, "model.skuList.updatedAt", model.skuList.get(i).updatedAt);
                    detailAssertTest(0, "model.skuList.confirmTime", model.skuList.get(i).confirmTime);
                    detailAssertTest(0, "model.skuList.platform_discount", model.skuList.get(i).platform_discount);
                    detailAssertTest(0, "model.skuList.saved_money", model.skuList.get(i).saved_money);
                    detailAssertTest(0, "model.skuList.discount_price", model.skuList.get(i).discount_price);

                    detailAssertTest("model.skuList.attrs", model.skuList.get(i).attrs);
                    detailAssertTest("下单时保质期", "model.skuList.attrs.规格", model.skuList.get(i).attrs.get(0).name);
                    detailAssertTest("2018/04/01生产-2028/02/08到期", "model.skuList.attrs.批次", model.skuList.get(i).attrs.get(0).value);

                    detailAssertTest(false, "model.skuList.canRefund", model.skuList.get(i).canRefund);
                } else {
                    detailAssertTest("订单sku信息验证失败", model.skuList.get(i).id);
                }
            }

            detailAssertTest(false, "model.canRefund", model.canRefund);
            detailAssertTest("好食期", "model.merchantName", model.merchantName);
            detailAssertTest("4006458058", "model.serviceTel", model.serviceTel);
            detailAssertTest(false, "model.canCancel", model.canCancel);
            detailAssertTest("交易关闭", "model.statusDesc", model.statusDesc);
            detailAssertTest("", "model.statusLogo", model.statusLogo);
            detailAssertTest("", "model.udesk_merchant_id", model.udesk_merchant_id);
            detailAssertTest("好食期-蜜我食铺", "model.udesk_merchant_name", model.udesk_merchant_name);
            detailAssertTest(100, "model.custom_service_id", model.custom_service_id);

            //确认订单页，公告显示，公告ID存在
            if (model.message != null) {
                detailAssertTest(18, "model.message.id", model.message.id);
                detailAssertTest(1, "model.message.channel_id", model.message.channel_id);
                detailAssertTest(4, "model.message.position", model.message.position);
                detailAssertTest(1557987292, "model.message.start_time", model.message.start_time);
                detailAssertTest(1588240457, "model.message.end_time", model.message.end_time);
                detailAssertTest("详情页测试公告", "model.message.title", model.message.title);
                detailAssertTest("确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告", "model.message.content", model.message.content);
                detailAssertTest(2, "model.message.status", model.message.status);
                detailAssertTest(1, "model.message.is_deleted", model.message.is_deleted);
            }
        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("2188781917", "model.id", model.id);
            detailAssertTest(7, "model.status", model.status);
            detailAssertTest("金竹", "model.consignee", model.consignee);
            detailAssertTest("", "model.note", model.note);
            detailAssertTest(0, "model.payways", model.payways);
            detailAssertTest("2188781917", "model.orderId", model.orderId);
            detailAssertTest(11318161, "model.userId", model.userId);
            detailAssertTest(0, "model.merchantId", model.merchantId);
            detailAssertTest(0, "model.addressId", model.addressId);
            detailAssertTest(0, "model.pointPaymentId", model.pointPaymentId);
            detailAssertTest(0, "model.point_payment_id", model.point_payment_id);
            detailAssertTest(6, "model.orderType", model.orderType);
            detailAssertTest(1, "model.deliveryType", model.deliveryType);
            detailAssertTest(1, "model.invoiceType", model.invoiceType);
            detailAssertTest("", "model.invoiceTitle", model.invoiceTitle);
            detailAssertTest("159****9570", "model.consigneePhone", model.consigneePhone);
            detailAssertTest(1, "model.needPayPrice", model.needPayPrice);
            detailAssertTest(1, "model.payPrice", model.payPrice);
            detailAssertTest(1, "model.totalPrice", model.totalPrice);
            detailAssertTest(0, "model.deliveryPrice", model.deliveryPrice);
            detailAssertTest(0, "model.merchantDiscount", model.merchantDiscount);
            detailAssertTest(0, "model.platformDiscount", model.platformDiscount);
            detailAssertTest(88, "model.totalPoint", model.totalPoint);
            detailAssertTest(1, "model.totalAmount", model.totalAmount);
            detailAssertTest(1, "model.deliveryStatus", model.deliveryStatus);
            detailAssertTest(1, "model.commentStatus", model.commentStatus);
            detailAssertTest("上海", "model.deliveryProvince", model.deliveryProvince);
            detailAssertTest("上海市", "model.deliveryCity", model.deliveryCity);
            detailAssertTest("宝山区", "model.deliveryDistrict", model.deliveryDistrict);
            detailAssertTest("大场镇沪太路3100号 尚大国际 C座301室(7号线上大路那)", "model.deliveryDetailAddress", model.deliveryDetailAddress);
            detailAssertTest("1557367670", "model.payTime", model.payTime);
            detailAssertTest(0, "model.deliveryTime", model.deliveryTime);
            detailAssertTest(0, "model.confirmTime", model.confirmTime);
            detailAssertTest(1557367370, "model.createdAt", model.createdAt);
            detailAssertTest(1557367414, "model.updatedAt", model.updatedAt);
            detailAssertTest(0, "model.discountPrice", model.discountPrice);
            detailAssertTest(0, "model.saved_money", model.saved_money);
            detailAssertTest(0, "model.solicitation_time", model.solicitation_time);
            detailAssertTest(0, "model.deductible_amount", model.deductible_amount);
            detailAssertTest(0, "model.premium_income", model.premium_income);
            detailAssertTest(0, "model.sham_total_price", model.sham_total_price);
            detailAssertTest("", "model.merchant_order_note", model.merchant_order_note);
            detailAssertTest(1557368570, "model.merchant_order_note", model.expire_ack_time);
            detailAssertTest("438464384473006383", "model.cps_name", model.cps_name);

            detailAssertTest("model.skuList", model.skuList);

            for (int i = 0; i < model.skuList.size(); i++) {

                if (model.skuList.get(i).id.equals("41336098")) {

                    detailAssertTest(1, "model.skuList.amount", model.skuList.get(i).amount);
                    detailAssertTest(7, "model.skuList.status", model.skuList.get(i).status);
                    detailAssertTest(88, "list.get(i).skuList.point", model.skuList.get(i).point);
                    detailAssertTest("[{\"name\":\"\\u4e0b\\u5355\\u65f6\\u4fdd\\u8d28\\u671f\",\"value\":\"1994\\/09\\/01\\u751f\\u4ea7-2037\\/05\\/31\\u5230\\u671f\"},{\"name\":\"\\u89c4\\u683c\",\"value\":\"200g\"}]", "model.skuList.attribute_tags", model.skuList.get(i).attribute_tags);
                    detailAssertTest(11318161, "model.skuList.userId", model.skuList.get(i).userId);
                    detailAssertTest("2188781917", "model.skuList.orderId", model.skuList.get(i).orderId);
                    detailAssertTest(70743, "model.skuList.productId", model.skuList.get(i).productId);
                    detailAssertTest(9429, "model.skuList.buSkuId", model.skuList.get(i).buSkuId);
                    detailAssertTest(85486, "model.skuList.skuId", model.skuList.get(i).skuId);
                    detailAssertTest("压测专用（勿动） 200g", "model.skuList.skuName", model.skuList.get(i).skuName);
                    detailAssertTest("http://img2.haoshiqi.net/maaa938eac8efc626a53e043574c88cdc9.jpg?imageView2/0/w/200/h/200/q/70", "model.skuList.skuThumbnail", model.skuList.get(i).skuThumbnail);
                    detailAssertTest(3, "model.skuList.marketPrice", model.skuList.get(i).marketPrice);
                    detailAssertTest(1, "modelskuList.totalPrice", model.skuList.get(i).totalPrice);
                    detailAssertTest(1, "model.skuList.payPrice", model.skuList.get(i).payPrice);
                    detailAssertTest(1, "model.skuList.unitPrice", model.skuList.get(i).unitPrice);
                    detailAssertTest(1, "model.skuList.commentStatus", model.skuList.get(i).commentStatus);
                    detailAssertTest(1557367370, "model.skuList.createdAt", model.skuList.get(i).createdAt);
                    detailAssertTest(1557367414, "model.skuList.updatedAt", model.skuList.get(i).updatedAt);
                    detailAssertTest(0, "model.skuList.confirmTime", model.skuList.get(i).confirmTime);
                    detailAssertTest(0, "model.skuList.platform_discount", model.skuList.get(i).platform_discount);
                    detailAssertTest(0, "model.skuList.saved_money", model.skuList.get(i).saved_money);
                    detailAssertTest(0, "model.skuList.discount_price", model.skuList.get(i).discount_price);

                    detailAssertTest("model.skuList.attrs", model.skuList.get(i).attrs);

                    detailAssertTest("下单时保质期", "model.skuList.attrs.规格", model.skuList.get(i).attrs.get(0).name);
                    detailAssertTest("1994/09/01生产-2037/05/31到期", "model.skuList.attrs.批次", model.skuList.get(i).attrs.get(0).value);
                    detailAssertTest("规格", "model.skuList.attrs.规格", model.skuList.get(i).attrs.get(1).name);
                    detailAssertTest("200g", "model.skuList.attrs.批次", model.skuList.get(i).attrs.get(1).value);

//                    detailAssertTest(false, "model.skuList.canRefund", model.skuList.get(i).canRefund);
                } else {
                    detailAssertTest("订单sku信息验证失败", model.skuList.get(i).id);
                }
            }

            detailAssertTest(false, "model.canRefund", model.canRefund);
            detailAssertTest(2253332, "model.merchantName", model.refundId);
            detailAssertTest(3, "model.serviceTel", model.refundStatus);
            detailAssertTest("退款成功", "model.canCancel", model.refundStatusDesc);
            detailAssertTest("好食期", "model.merchantName", model.merchantName);
            detailAssertTest("4001858058", "model.serviceTel", model.serviceTel);
            detailAssertTest(false, "model.canCancel", model.canCancel);
            detailAssertTest("已退款", "model.statusDesc", model.statusDesc);
            detailAssertTest(false, "model.statusDesc", model.canViewDelivery);
            detailAssertTest("http://img1.haoshiqi.net/resource/trade_refund.png", "model.statusLogo", model.statusLogo);
            detailAssertTest("", "model.udesk_merchant_id", model.udesk_merchant_id);
            detailAssertTest("好食期-淘食铺", "model.udesk_merchant_name", model.udesk_merchant_name);
            detailAssertTest(100, "model.custom_service_id", model.custom_service_id);

            //确认订单页，公告显示，公告ID存在
            if (model.message != null) {
//            detailAssertTest(18, "model.message.id", model.message.id);
//            detailAssertTest(1, "model.message.channel_id", model.message.channel_id);
//            detailAssertTest(4, "model.message.position", model.message.position);
//            detailAssertTest(1557987292, "model.message.start_time", model.message.start_time);
//            detailAssertTest(1588240457, "model.message.end_time", model.message.end_time);
//            detailAssertTest("详情页测试公告", "model.message.title", model.message.title);
//            detailAssertTest("确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告确认页测试公告", "model.message.content", model.message.content);
//            detailAssertTest(2, "model.message.status", model.message.status);
//            detailAssertTest(1, "model.message.is_deleted", model.message.is_deleted);

            }
        }
    }
}
