package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.PointIteminfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class point_iteminfo_test extends HsqInterfaceTest {


    private PointIteminfoData model;


    @Test(description = "积分商品详情页列表")
    public void point_iteminfo_true() {
        setUrl("point.iteminfo.uri");
        param = "pSkuId=" + SqlDetail.getParamValue("pSkuId");
        process(true, false);

        model = sparseJson(PointIteminfoData.class);
        pointIteminfoAssert();

    }

    private void pointIteminfoAssert() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(28659, "skuId", model.skuId);
            detailAssertTest(25302, "productId", model.productId);
            detailAssertTest(616, "merchantId", model.merchantId);
            detailAssertTest("接口测试专用商品，勿动动", "name", model.name);
            detailAssertTest(1099, "price", model.price);
            detailAssertTest(5000, "lmarketPrice", model.marketPrice);
            detailAssertTest("http://img2.haoshiqi.net/ma32483124920c8aea275a83545aa3b5aa.jpg?imageView2/0/w/420/h/420/q/70", "thumbnail", model.thumbnail);
            detailAssertTest( "point", model.point);
            detailAssertTest( "pointMetaId", model.pointMetaId);
            detailAssertTest(1, "channelId", model.channelId);
            detailAssertTest(1522512000, "startTime", model.startTime);
            detailAssertTest(1893427200, "endTime", model.endTime);
            detailAssertTest(2, "auditStatus", model.auditStatus);
            detailAssertTest("auditTime", model.auditTime);
            detailAssertTest(1, "enabled", model.enabled);
            detailAssertTest(0, "isDelete", model.isDelete);
            detailAssertTest(0, "priority", model.priority);
            detailAssertTest(1523873621, "createdAt", model.createdAt);
            detailAssertTest(1523873624, "productId", model.updatedAt);
            detailAssertTest(1, "type", model.type);
            detailAssertTest("pointRules", model.pointRules);
            detailAssertTest(1, "listDisplay", model.listDisplay);
            detailAssertTest("[\"1\",\"2\",\"3\"]", "subchannel", model.subchannel);
            detailAssertTest( "mappingId", model.mappingId);
            detailAssertTest(0, "countLimit", model.countLimit);

            detailAssertTest("model.attrs", model.attrs);
            for (int i = 0; i < model.attrs.size(); i++) {
                if (model.attrs.get(i).name.equals("保质期")) {
                    detailAssertTest("2018/04/01生产-2028/02/08到期", "attrs.value", model.attrs.get(i).value);
                } else {
                    detailAssertTest("保质期和规格验证失败", "attrs.name", model.attrs.get(i).name);
                }
            }

            detailAssertTest("model.pointRulesDesc", model.pointRulesDesc);
            detailAssertTest( "","pointRulesDesc.get(0).name", model.pointRulesDesc.get(0).name);
            detailAssertTest("pointRulesDesc.get(0).point", model.pointRulesDesc.get(0).point);
            detailAssertTest("pointRulesDesc.get(0).grade", model.pointRulesDesc.get(0).grade);


            detailAssertTest("", "description", model.description);
            detailAssertTest("不支持配送区域: 内蒙古自治区、西藏自治区、青海省、宁夏回族自治区、新疆维吾尔自治区", "deliveryRangeTip", model.deliveryRangeTip);

//            detailAssertTest(999932, "leftStock", model.leftStock);

            detailAssertTest("https://img2.haoshiqi.net/freeMail@3x.png", "merchantInfo.labels.get(0).icon)", model.merchantInfo.labels.get(0).icon);
            detailAssertTest("本商品满1件包邮", "merchantInfo.labels.get(0).text", model.merchantInfo.labels.get(0).text);
            detailAssertTest("蜜我食铺", "merchmerchantInfo.nameantInfo", model.merchantInfo.name);
            detailAssertTest("", "merchantInfo.udesk_merchant_id", model.merchantInfo.udesk_merchant_id);
            detailAssertTest("好食期-蜜我食铺", "merchantInfo.udesk_merchant_namext", model.merchantInfo.udesk_merchant_name);

            detailAssertTest("batchOptions", model.batchOptions);
            detailAssertTest("1833552000", "batchOptions.get(0).batch", model.batchOptions.get(0).batch);
            detailAssertTest(2669, "batchOptions.get(0).pSkuId", model.batchOptions.get(0).pSkuId);
            detailAssertTest( "batchOptions.get(0).price", model.batchOptions.get(0).price);
            detailAssertTest("1833552000", "batchOptions.get(0).expired_date", model.batchOptions.get(0).expired_date);
            detailAssertTest("1522512000", "atchOptions.get(0).manufactured_date", model.batchOptions.get(0).manufactured_date);
            detailAssertTest("1522512000", "batchOptions.get(0).seller_time)", model.batchOptions.get(0).seller_time);
            detailAssertTest(1900, "batchOptions.get(0).lowest_price", model.batchOptions.get(0).lowest_price);
            detailAssertTest(2592000, "batchOptions.get(0).offline_before_expired", model.batchOptions.get(0).offline_before_expired);

            detailAssertTest("model.attrOptions", model.attrOptions);
            for (int i = 0; i < model.attrOptions.size(); i++) {
                if (model.attrOptions.get(i).name.equals("保质期")) {
                    detailAssertTest("attrOptions.list", model.attrOptions.get(i).list);
                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                        detailAssertTest("2018/04/01-2028/02/08", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
                        detailAssertTest(2669, "attrOptions.list.pSkuId", model.attrOptions.get(i).list.get(j).pSkuId);
                    }
                } else {
                    detailAssertTest("保质期和规格验证失败", "attrOptions.name", model.attrOptions.get(i).name);
                }
            }

            detailAssertTest(0, "ugcBrief.totalCnt", model.ugcBrief.totalCnt);

            detailAssertTest("model.pics", model.pics);
            detailAssertTest("http://img2.haoshiqi.net/ma32483124920c8aea275a83545aa3b5aa.jpg?imageView2/0/w/840/h/840/q/70", "lpics.get(0)", model.pics.get(0));
            detailAssertTest("http://img2.haoshiqi.net/ma957f7a4f209ef5e58c7f8b8552d27af5.jpg?imageView2/0/w/840/h/840/q/70", "lpics.get(1)", model.pics.get(1));


            detailAssertTest("model.labels", model.labels);
            for (int i = 0; i < model.labels.size(); i++) {
                if (model.labels.get(i).text.equals("正品保证")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(0).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=1", "labels.get(0).link", model.labels.get(i).link);
                } else if (model.labels.get(i).text.equals("PICC承保")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(1).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=2", "labels.get(1).link", model.labels.get(i).link);

                } else if (model.labels.get(i).text.equals("24小时内发货")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(2).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=4&time=24", "labels.get(2).link", model.labels.get(i).link);

                } else if (model.labels.get(i).text.equals("售后无忧")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(3).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=3", "labels.get(3).link", model.labels.get(i).link);
                } else {
                    detailAssertTest("正品保证,PICC承保,24小时内发货,售后无忧验证失败！", "labels.get(i).text", model.labels.get(i).text);
                }
            }


            detailAssertTest(2669, "pSkuId", model.pSkuId);
            detailAssertTest(1522512000, "manufactured_date", model.manufactured_date);
            detailAssertTest(1833552000, "expired_date", model.expired_date);
            detailAssertTest(2592000, "offline_before_expired", model.offline_before_expired);
            detailAssertTest("1833552000", "batch", model.batch);
            detailAssertTest("pointSku", "skuType", model.skuType);
            detailAssertTest(1, "merchant_type", model.merchant_type);
            detailAssertTest(100, "custom_service_id", model.custom_service_id);

        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest(85486, "skuId", model.skuId);
            detailAssertTest(70743, "productId", model.productId);
            detailAssertTest(1786, "merchantId", model.merchantId);
            detailAssertTest("压测专用（勿动）", "name", model.name);
            detailAssertTest("price", model.price);
            detailAssertTest(3, "lmarketPrice", model.marketPrice);
            detailAssertTest("http://img2.haoshiqi.net/maaa938eac8efc626a53e043574c88cdc9.jpg?imageView2/0/w/420/h/420/q/70", "thumbnail", model.thumbnail);
            detailAssertTest( "point", model.point);
            detailAssertTest("pointMetaId", model.pointMetaId);
            detailAssertTest(1, "channelId", model.channelId);
            detailAssertTest(1556640000, "startTime", model.startTime);
            detailAssertTest(2080051200, "endTime", model.endTime);
            detailAssertTest(2, "auditStatus", model.auditStatus);
            detailAssertTest( "auditTime", model.auditTime);
            detailAssertTest(1, "enabled", model.enabled);
            detailAssertTest(0, "isDelete", model.isDelete);
            detailAssertTest(0, "priority", model.priority);
            detailAssertTest(1557365590, "createdAt", model.createdAt);
            detailAssertTest(1557365590, "productId", model.updatedAt);
            detailAssertTest(1, "type", model.type);
            detailAssertTest( "pointRules", model.pointRules);
            detailAssertTest(0, "listDisplay", model.listDisplay);
//            detailAssertTest("[\"2\",\"3\"]", "subchannel", model.subchannel);
            detailAssertTest( "mappingId", model.mappingId);
            detailAssertTest(0, "countLimit", model.countLimit);

            detailAssertTest("model.attrs", model.attrs);
            for (int i = 0; i < model.attrs.size(); i++) {
                if (model.attrs.get(i).name.equals("保质期")) {
                    detailAssertTest("1994/09/01生产-2037/05/31到期", "attrs.value", model.attrs.get(i).value);
                } else if (model.attrs.get(i).name.equals("规格")) {
                    detailAssertTest("200g", "attrs.value", model.attrs.get(i).value);
                } else {
                    detailAssertTest("保质期和规格验证失败", "attrs.name", model.attrs.get(i).name);
                }
            }

            detailAssertTest("model.pointRulesDesc", model.pointRulesDesc);
            detailAssertTest( "","pointRulesDesc.get(0).name", model.pointRulesDesc.get(0).name);
            detailAssertTest( "pointRulesDesc.get(0).point", model.pointRulesDesc.get(0).point);
            detailAssertTest("pointRulesDesc.get(0).grade", model.pointRulesDesc.get(0).grade);


            detailAssertTest("", "description", model.description);
            detailAssertTest("", "deliveryRangeTip", model.deliveryRangeTip);

//            detailAssertTest(999939, "leftStock", model.leftStock);
//            detailAssertTest("https://img2.haoshiqi.net/freeMail@3x.png", "merchantInfo.labels.get(0).icon)", model.merchantInfo.labels.get(0).icon);
//            detailAssertTest("本商品满1件包邮", "merchantInfo.labels.get(0).text", model.merchantInfo.labels.get(0).text);
            detailAssertTest("淘食铺", "merchmerchantInfo.nameantInfo", model.merchantInfo.name);
            detailAssertTest("", "merchantInfo.udesk_merchant_id", model.merchantInfo.udesk_merchant_id);
            detailAssertTest("好食期-淘食铺", "merchantInfo.udesk_merchant_namext", model.merchantInfo.udesk_merchant_name);

//            detailAssertTest("batchOptions", model.batchOptions);
//            detailAssertTest("2127312000", "batchOptions.get(0).batch", model.batchOptions.get(0).batch);
//            detailAssertTest(9429, "batchOptions.get(0).pSkuId", model.batchOptions.get(0).pSkuId);
//            detailAssertTest(1, "batchOptions.get(0).price", model.batchOptions.get(0).price);
//            detailAssertTest("2127312000", "batchOptions.get(0).expired_date", model.batchOptions.get(0).expired_date);
//            detailAssertTest("778348800", "atchOptions.get(0).manufactured_date", model.batchOptions.get(0).manufactured_date);
//            detailAssertTest("1556640000", "batchOptions.get(0).seller_time)", model.batchOptions.get(0).seller_time);
//            detailAssertTest(3, "batchOptions.get(0).lowest_price", model.batchOptions.get(0).lowest_price);
//            detailAssertTest(2592000, "batchOptions.get(0).offline_before_expired", model.batchOptions.get(0).offline_before_expired);

            detailAssertTest("model.attrOptions", model.attrOptions);
            for (int i = 0; i < model.attrOptions.size(); i++) {
                if (model.attrOptions.get(i).name.equals("保质期")) {
//                    detailAssertTest("attrOptions.list", model.attrOptions.get(i).list);
//                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
//                        detailAssertTest("1994/09/01-2037/05/31", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
//                        detailAssertTest(9429, "attrOptions.list.pSkuId", model.attrOptions.get(i).list.get(j).pSkuId);
//                    }
                } else if (model.attrOptions.get(i).name.equals("规格")) {
//                    for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
//                        detailAssertTest("200g", "attrOptions.list.value", model.attrOptions.get(i).list.get(j).value);
//                        detailAssertTest(9429, "attrOptions.list.pSkuId", model.attrOptions.get(i).list.get(j).pSkuId);
//                    }
                } else {
                    detailAssertTest("保质期和规格验证失败", "attrOptions.name", model.attrOptions.get(i).name);
                }
            }

            detailAssertTest(0, "ugcBrief.totalCnt", model.ugcBrief.totalCnt);

            detailAssertTest("model.pics", model.pics);
            detailAssertTest("http://img2.haoshiqi.net/maaa938eac8efc626a53e043574c88cdc9.jpg?imageView2/0/w/840/h/840/q/70", "lpics.get(0)", model.pics.get(0));
            detailAssertTest("http://img2.haoshiqi.net/ma25a4a7e863ae9850e316bdddee91c8ca.jpg?imageView2/0/w/840/h/840/q/70", "lpics.get(1)", model.pics.get(1));


            detailAssertTest("model.labels", model.labels);
            for (int i = 0; i < model.labels.size(); i++) {
                if (model.labels.get(i).text.equals("正品保证")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(0).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=1", "labels.get(0).link", model.labels.get(i).link);
                } else if (model.labels.get(i).text.equals("PICC承保")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(1).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=2", "labels.get(1).link", model.labels.get(i).link);

                } else if (model.labels.get(i).text.equals("48小时内发货")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(2).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=4&time=48", "labels.get(2).link", model.labels.get(i).link);

                } else if (model.labels.get(i).text.equals("售后无忧")) {
                    detailAssertTest("https://img2.haoshiqi.net/item_detail_check@3x.png", "labels.get(3).icon", model.labels.get(i).icon);
                    detailAssertTest("https://img1.haoshiqi.net/html/index.html?type=3", "labels.get(3).link", model.labels.get(i).link);
                } else {
                    detailAssertTest("正品保证,PICC承保,24小时内发货,售后无忧验证失败！", "labels.get(i).text", model.labels.get(i).text);
                }
            }

            detailAssertTest(9429, "pSkuId", model.pSkuId);
            detailAssertTest(778348800, "manufactured_date", model.manufactured_date);
            detailAssertTest(2127312000, "expired_date", model.expired_date);
            detailAssertTest(2592000, "offline_before_expired", model.offline_before_expired);
            detailAssertTest("2127312000", "batch", model.batch);
            detailAssertTest("pointSku", "skuType", model.skuType);
            detailAssertTest(1, "merchant_type", model.merchant_type);
            detailAssertTest(100, "custom_service_id", model.custom_service_id);

        }
    }
}
