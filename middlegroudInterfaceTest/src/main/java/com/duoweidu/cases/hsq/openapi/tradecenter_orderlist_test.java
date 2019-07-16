package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.TradecenterOrderlistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class tradecenter_orderlist_test extends HsqInterfaceTest {


    TradecenterOrderlistData model;


    private void interfaces() {
        setUrl("tradecenter.orderlist.uri");
        process(true, true);
        model = sparseJson(TradecenterOrderlistData.class);
        HsqOpenapiConfig.totalPage = model.totalPage;
    }


    @Test(description = "订单列表")
    public void tradecenter_orderlist_true() {

        param = "token=" + SqlDetail.getInstance().getParamValue("token");
        interfaces();

        // 如果只有一页，则不需要根据最后一页查询订单
        if (HsqOpenapiConfig.totalPage == 1) {
            tradecenterOrderlistAssert();
        } else {
            tradecenter_orderlist_true_totalPage();
        }

    }

    // "订单列表-查询最后一页的订单"
    public void tradecenter_orderlist_true_totalPage() {

        param = "token=" + SqlDetail.getInstance().getParamValue("token") + "&pageNum=" + HsqOpenapiConfig.totalPage;
        interfaces();
        tradecenterOrderlistAssert();

    }


    private void tradecenterOrderlistAssert() {

        if ("beta".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest("model.list", model.list);

            //根据用户订单倒着循环，考虑到用户订单会有新订单
            for (int i = model.list.size() - 1; i >= 0; i--) {

                //已退款的订单
                if (model.list.get(i).id.equals("2163944808")) {
                    detailAssertTest(7, "list.get(i).status", model.list.get(i).status);
                    detailAssertTest("红红", "list.get(i).consignee", model.list.get(i).consignee);
                    detailAssertTest("", "list.get(i).note", model.list.get(i).note);
                    detailAssertTest(3, "list.get(i).payways", model.list.get(i).payways);
                    detailAssertTest("2163944808", "list.get(i).orderId", model.list.get(i).orderId);
                    detailAssertTest(23391725, "list.get(i).userId", model.list.get(i).userId);
                    detailAssertTest(0, "list.get(i).merchantId", model.list.get(i).merchantId);
                    detailAssertTest(1902, "list.get(i).addressId", model.list.get(i).addressId);
                    detailAssertTest(1213, "list.get(i).pointPaymentId", model.list.get(i).pointPaymentId);
                    detailAssertTest(1213, "list.get(i).point_payment_id", model.list.get(i).point_payment_id);
                    detailAssertTest(6, "list.get(i).orderType", model.list.get(i).orderType);
                    detailAssertTest(1, "list.get(i).deliveryType", model.list.get(i).deliveryType);
                    detailAssertTest(1, "list.get(i).invoiceType", model.list.get(i).invoiceType);
                    detailAssertTest("", "list.get(i).invoiceTitle", model.list.get(i).invoiceTitle);
                    detailAssertTest("130****6002", "list.get(i).consigneePhone", model.list.get(i).consigneePhone);
                    detailAssertTest(1, "list.get(i).needPayPrice", model.list.get(i).needPayPrice);
                    detailAssertTest(1, "list.get(i).payPrice", model.list.get(i).payPrice);
                    detailAssertTest(1, "list.get(i).totalPrice", model.list.get(i).totalPrice);
                    detailAssertTest(0, "list.get(i).deliveryPrice", model.list.get(i).deliveryPrice);
                    detailAssertTest(0, "list.get(i).merchantDiscount", model.list.get(i).merchantDiscount);
                    detailAssertTest(0, "list.get(i).platformDiscount", model.list.get(i).platformDiscount);
                    detailAssertTest(10, "list.get(i).totalPoint", model.list.get(i).totalPoint);
                    detailAssertTest(1, "list.get(i).totalAmount", model.list.get(i).totalAmount);
                    detailAssertTest(1, "list.get(i).deliveryStatus", model.list.get(i).deliveryStatus);
                    detailAssertTest(1, "list.get(i).commentStatus", model.list.get(i).commentStatus);
                    detailAssertTest("北京", "list.get(i).deliveryProvince", model.list.get(i).deliveryProvince);
                    detailAssertTest("北京市", "list.get(i).deliveryCity", model.list.get(i).deliveryCity);
                    detailAssertTest("东城区", "list.get(i).deliveryDistrict", model.list.get(i).deliveryDistrict);
                    detailAssertTest("110101", "list.get(i).deliveryDetailAddress", model.list.get(i).deliveryDetailAddress);
                    detailAssertTest("1561014878", "list.get(i).payTime", model.list.get(i).payTime);
                    detailAssertTest(0, "list.get(i).deliveryTime", model.list.get(i).deliveryTime);
                    detailAssertTest(0, "list.get(i).confirmTime", model.list.get(i).confirmTime);
                    detailAssertTest(1561014872, "list.get(i).createdAt", model.list.get(i).createdAt);
                    detailAssertTest(1561014912, "list.get(i).updatedAt", model.list.get(i).updatedAt);
                    detailAssertTest(0, "list.get(i).discountPrice", model.list.get(i).discountPrice);

                    detailAssertTest("list.get(i).skuList", model.list.get(i).skuList);
                    for (int j = 0; j < model.list.get(i).skuList.size(); j++) {
                        if (model.list.get(i).skuList.get(j).id.equals("16492968")) {

                            detailAssertTest(1, "list.get(i).skuList.amount", model.list.get(i).skuList.get(j).amount);
                            detailAssertTest(7, "list.get(i).skuList.status", model.list.get(i).skuList.get(j).status);
                            detailAssertTest(10, "list.get(i).skuList.point", model.list.get(i).skuList.get(j).point);
                            detailAssertTest("[{\"name\":\"\\u4e0b\\u5355\\u65f6\\u4fdd\\u8d28\\u671f\",\"value\":\"2018\\/04\\/15\\u751f\\u4ea7-2019\\/07\\/09\\u5230\\u671f\"},{\"name\":\"\\u89c4\\u683c\",\"value\":\"600g\"}]", "list.get(i).skuList.attribute_tags", model.list.get(i).skuList.get(j).attribute_tags);
                            detailAssertTest(23391725, "list.get(i).skuList.userId", model.list.get(i).skuList.get(j).userId);
                            detailAssertTest("2163944808", "list.get(i).skuList.orderId", model.list.get(i).skuList.get(j).orderId);
                            detailAssertTest(28643, "list.get(i).skuList.productId", model.list.get(i).skuList.get(j).productId);
                            detailAssertTest(2848, "list.get(i).skuList.buSkuId", model.list.get(i).skuList.get(j).buSkuId);
                            detailAssertTest(34358, "list.get(i).skuList.skuId", model.list.get(i).skuList.get(j).skuId);
                            detailAssertTest("啊啊啊啊商品信息图", "list.get(i).skuList.skuName", model.list.get(i).skuList.get(j).skuName);
                            detailAssertTest("http://img2.haoshiqi.net/mafa96f64265271d23bcdd2cdf3a5a163a.jpg?imageView2/0/w/200/h/200/q/70", "list.get(i).skuList.skuThumbnail", model.list.get(i).skuList.get(j).skuThumbnail);
                            detailAssertTest(1500, "list.get(i).skuList.marketPrice", model.list.get(i).skuList.get(j).marketPrice);
                            detailAssertTest(1, "list.get(i).skuList.totalPrice", model.list.get(i).skuList.get(j).totalPrice);
                            detailAssertTest(0, "list.get(i).skuList.payPrice", model.list.get(i).skuList.get(j).payPrice);
                            detailAssertTest(1, "list.get(i).skuList.unitPrice", model.list.get(i).skuList.get(j).unitPrice);
                            detailAssertTest(1, "list.get(i).skuList.commentStatus", model.list.get(i).skuList.get(j).commentStatus);
                            detailAssertTest(1561014872, "list.get(i).skuList.createdAt", model.list.get(i).skuList.get(j).createdAt);
                            detailAssertTest(1561014913, "list.get(i).skuList.updatedAt", model.list.get(i).skuList.get(j).updatedAt);
                            detailAssertTest(0, "list.get(i).skuList.confirmTime", model.list.get(i).skuList.get(j).confirmTime);
                            detailAssertTest(0, "list.get(i).skuList.platform_discount", model.list.get(i).skuList.get(j).platform_discount);
                            detailAssertTest(0, "list.get(i).skuList.saved_money", model.list.get(i).skuList.get(j).saved_money);
                            detailAssertTest(0, "list.get(i).skuList.discount_price", model.list.get(i).skuList.get(j).discount_price);

                            detailAssertTest("list.get(i).skuList.attrs", model.list.get(i).skuList.get(j).attrs);
                            detailAssertTest("600g", "list.get(i).skuList.attrs.规格", model.list.get(i).skuList.get(j).attrs.get(0).规格);
                            detailAssertTest("1562601600", "list.get(i).skuList.attrs.批次", model.list.get(i).skuList.get(j).attrs.get(1).批次);

//                            detailAssertTest(false, "list.get(i).skuList.canRefund", model.list.get(i).skuList.get(j).canRefund);

                        } else {
                            detailAssertTest("订单sku信息验证失败", "list.get(i).skuList.id", model.list.get(i).skuList.get(j).id);
                        }
                    }

                    detailAssertTest(false, "list.get(i).canRefund", model.list.get(i).canRefund);
                    detailAssertTest(1007655, "list.get(i).skuList.canRefund", model.list.get(i).refundId);
                    detailAssertTest(3, "list.get(i).skuList.canRefund", model.list.get(i).refundStatus);
                    detailAssertTest("退款成功", "list.get(i).skuList.canRefund", model.list.get(i).refundStatusDesc);
                    detailAssertTest("好食期", "list.get(i).merchantName", model.list.get(i).merchantName);
                    detailAssertTest("4006458058", "list.get(i).serviceTel", model.list.get(i).serviceTel);
                    detailAssertTest(false, "list.get(i).canCancel", model.list.get(i).canCancel);
                    detailAssertTest("已退款", "list.get(i).statusDesc", model.list.get(i).statusDesc);
                    detailAssertTest("http://img1.haoshiqi.net/resource/trade_refund.png", "list.get(i).statusLogo", model.list.get(i).statusLogo);

                    //跳出循环
                    break;

                } else {
                    detailAssertTest("订单列表（已退款类型）信息验证失败", "list.get(i).id", model.list.get(i).id);
                }
            }

        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest("model.list", model.list);

            //根据用户订单倒着循环，考虑到用户订单会有新订单
            for (int i = model.list.size() - 1; i >= 0; i--) {

                //交易关闭的订单
                if (model.list.get(i).id.equals("2150230493")) {
                    detailAssertTest(4, "list.get(i).status", model.list.get(i).status);
                    detailAssertTest("左华健", "list.get(i).consignee", model.list.get(i).consignee);
                    detailAssertTest("", "list.get(i).note", model.list.get(i).note);
                    detailAssertTest(3, "list.get(i).payways", model.list.get(i).payways);
                    detailAssertTest("2150230493", "list.get(i).orderId", model.list.get(i).orderId);
                    detailAssertTest(11318161, "list.get(i).userId", model.list.get(i).userId);
                    detailAssertTest(0, "list.get(i).merchantId", model.list.get(i).merchantId);
                    detailAssertTest(11315243, "list.get(i).addressId", model.list.get(i).addressId);
                    detailAssertTest(319307, "list.get(i).pointPaymentId", model.list.get(i).pointPaymentId);
                    detailAssertTest(319307, "list.get(i).point_payment_id", model.list.get(i).point_payment_id);
                    detailAssertTest(6, "list.get(i).orderType", model.list.get(i).orderType);
                    detailAssertTest(1, "list.get(i).deliveryType", model.list.get(i).deliveryType);
                    detailAssertTest(1, "list.get(i).invoiceType", model.list.get(i).invoiceType);
                    detailAssertTest("", "list.get(i).invoiceTitle", model.list.get(i).invoiceTitle);
                    detailAssertTest("159****2921", "list.get(i).consigneePhone", model.list.get(i).consigneePhone);
                    detailAssertTest(2800, "list.get(i).needPayPrice", model.list.get(i).needPayPrice);
                    detailAssertTest(0, "list.get(i).payPrice", model.list.get(i).payPrice);
                    detailAssertTest(2800, "list.get(i).totalPrice", model.list.get(i).totalPrice);
                    detailAssertTest(0, "list.get(i).deliveryPrice", model.list.get(i).deliveryPrice);
                    detailAssertTest(0, "list.get(i).merchantDiscount", model.list.get(i).merchantDiscount);
                    detailAssertTest(0, "list.get(i).platformDiscount", model.list.get(i).platformDiscount);
                    detailAssertTest(88, "list.get(i).totalPoint", model.list.get(i).totalPoint);
                    detailAssertTest(1, "list.get(i).totalAmount", model.list.get(i).totalAmount);
                    detailAssertTest(1, "list.get(i).deliveryStatus", model.list.get(i).deliveryStatus);
                    detailAssertTest(1, "list.get(i).commentStatus", model.list.get(i).commentStatus);
                    detailAssertTest("上海", "list.get(i).deliveryProvince", model.list.get(i).deliveryProvince);
                    detailAssertTest("上海市", "list.get(i).deliveryCity", model.list.get(i).deliveryCity);
                    detailAssertTest("宝山区", "list.get(i).deliveryDistrict", model.list.get(i).deliveryDistrict);
                    detailAssertTest("环镇北路385号（柯达照相馆）", "list.get(i).deliveryDetailAddress", model.list.get(i).deliveryDetailAddress);
                    detailAssertTest(null, "list.get(i).payTime", model.list.get(i).payTime);
                    detailAssertTest(0, "list.get(i).deliveryTime", model.list.get(i).deliveryTime);
                    detailAssertTest(0, "list.get(i).confirmTime", model.list.get(i).confirmTime);
                    detailAssertTest(1499768518, "list.get(i).createdAt", model.list.get(i).createdAt);
                    detailAssertTest(1499772122, "list.get(i).updatedAt", model.list.get(i).updatedAt);
                    detailAssertTest(0, "list.get(i).discountPrice", model.list.get(i).discountPrice);

                    detailAssertTest("list.get(i).skuList", model.list.get(i).skuList);
                    for (int j = 0; j < model.list.get(i).skuList.size(); j++) {
                        if (model.list.get(i).skuList.get(j).id.equals("2785927")) {

                            detailAssertTest(1, "list.get(i).skuList.amount", model.list.get(i).skuList.get(j).amount);
                            detailAssertTest(4, "list.get(i).skuList.status", model.list.get(i).skuList.get(j).status);
                            detailAssertTest(88, "list.get(i).skuList.point", model.list.get(i).skuList.get(j).point);
                            detailAssertTest("", "list.get(i).skuList.attribute_tags", model.list.get(i).skuList.get(j).attribute_tags);
                            detailAssertTest(11318161, "list.get(i).skuList.userId", model.list.get(i).skuList.get(j).userId);
                            detailAssertTest("2150230493", "list.get(i).skuList.orderId", model.list.get(i).skuList.get(j).orderId);
                            detailAssertTest(14515, "list.get(i).skuList.productId", model.list.get(i).skuList.get(j).productId);
                            detailAssertTest(325, "list.get(i).skuList.buSkuId", model.list.get(i).skuList.get(j).buSkuId);
                            detailAssertTest(16905, "list.get(i).skuList.skuId", model.list.get(i).skuList.get(j).skuId);
                            detailAssertTest("中粮美滋滋 每日坚果（25g*7包）", "list.get(i).skuList.skuName", model.list.get(i).skuList.get(j).skuName);
                            detailAssertTest("http://img2.haoshiqi.net/ma9e0cc24d85d52a77655fdd804f458c53.jpg?imageView2/0/w/200/h/200/q/70", "list.get(i).skuList.skuThumbnail", model.list.get(i).skuList.get(j).skuThumbnail);
                            detailAssertTest(5900, "list.get(i).skuList.marketPrice", model.list.get(i).skuList.get(j).marketPrice);
                            detailAssertTest(2800, "list.get(i).skuList.totalPrice", model.list.get(i).skuList.get(j).totalPrice);
                            detailAssertTest(0, "list.get(i).skuList.payPrice", model.list.get(i).skuList.get(j).payPrice);
                            detailAssertTest(2800, "list.get(i).skuList.unitPrice", model.list.get(i).skuList.get(j).unitPrice);
                            detailAssertTest(1, "list.get(i).skuList.commentStatus", model.list.get(i).skuList.get(j).commentStatus);
                            detailAssertTest(1499768518, "list.get(i).skuList.createdAt", model.list.get(i).skuList.get(j).createdAt);
                            detailAssertTest(1499772121, "list.get(i).skuList.updatedAt", model.list.get(i).skuList.get(j).updatedAt);
                            detailAssertTest(0, "list.get(i).skuList.confirmTime", model.list.get(i).skuList.get(j).confirmTime);
                            detailAssertTest(0, "list.get(i).skuList.platform_discount", model.list.get(i).skuList.get(j).platform_discount);
                            detailAssertTest(0, "list.get(i).skuList.saved_money", model.list.get(i).skuList.get(j).saved_money);
                            detailAssertTest(0, "list.get(i).skuList.discount_price", model.list.get(i).skuList.get(j).discount_price);

                            detailAssertTest("list.get(i).skuList.attrs", model.list.get(i).skuList.get(j).attrs);
//                            detailAssertTest("600g", "list.get(i).skuList.attrs.规格", model.list.get(i).skuList.get(j).attrs.get(0).规格);
                            detailAssertTest("1529424000", "list.get(i).skuList.attrs.批次", model.list.get(i).skuList.get(j).attrs.get(0).批次);

                            detailAssertTest(false, "list.get(i).skuList.canRefund", model.list.get(i).skuList.get(j).canRefund);

                        } else {
                            detailAssertTest("订单sku信息验证失败", "list.get(i).skuList.id", model.list.get(i).skuList.get(j).id);
                        }
                    }

                    detailAssertTest(false, "list.get(i).canRefund", model.list.get(i).canRefund);
//                    detailAssertTest(1007655, "list.get(i).skuList.canRefund", model.list.get(i).refundId);
//                    detailAssertTest(3, "list.get(i).skuList.canRefund", model.list.get(i).refundStatus);
//                    detailAssertTest("退款成功", "list.get(i).skuList.canRefund", model.list.get(i).refundStatusDesc);
                    detailAssertTest("好食期", "list.get(i).merchantName", model.list.get(i).merchantName);
                    detailAssertTest("4001858058", "list.get(i).serviceTel", model.list.get(i).serviceTel);
                    detailAssertTest(false, "list.get(i).canCancel", model.list.get(i).canCancel);
                    detailAssertTest("交易关闭", "list.get(i).statusDesc", model.list.get(i).statusDesc);
                    detailAssertTest("","list.get(i).statusLogo", model.list.get(i).statusLogo);

                    //跳出循环
                    break;

                } else {
                    detailAssertTest("订单列表（交易关闭类型）信息验证失败", "list.get(i).id", model.list.get(i).id);
                }
            }
        }
    }
}
