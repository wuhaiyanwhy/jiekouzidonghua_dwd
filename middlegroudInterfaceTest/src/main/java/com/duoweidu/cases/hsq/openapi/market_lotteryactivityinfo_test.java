package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.MarketLotteryactivityinfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class market_lotteryactivityinfo_test extends HsqInterfaceTest {

    private MarketLotteryactivityinfoData model;

    @Test(dependsOnGroups = "loginTrue",description = "抽奖团活动信息")
    public void market_lotteryactivityinfo_true() {
        setUrl("market.lotteryactivityinfo.uri");
        param = "pinActivitiesId=" + SqlDetail.getInstance().getParamValue("chouActivitiesId");
        process(true,false);
        model = sparseJson(MarketLotteryactivityinfoData.class);
        detailAssert();

    }
    private void detailAssert() {
        detailAssertTest(2, "status", model.status);
        detailAssertTest(1, "canBuy", model.canBuy);
        detailAssertTest(0, "canSub", model.canSub);
        detailAssertTest(0, "canUnSub", model.canUnSub);
        detailAssertTest(Integer.parseInt(SqlDetail.getInstance().getParamValue("chouActivitiesId")), "pinActivitiesId", model.pinActivitiesId);
        detailAssertTest(2, "type", model.type);
        detailAssertTest(1, "remindStatus", model.remindStatus);
        detailAssertTest(0, "hasBeenLottery", model.hasBeenLottery);
        detailAssertTest(0, "joinCount", model.joinCount);
        detailAssertTest("rule", model.rule);
        detailAssertTest("countLimit", model.countLimit);
        detailAssertTest("joinTimesLimit", model.joinTimesLimit);
        detailAssertTest(1, "skuInfo.enabled", model.skuInfo.enabled);
        detailAssertTest("skuInfo.liked_cnt", String.valueOf(model.skuInfo.liked_cnt));
        detailAssertTest("skuInfo.ugc_cnt", String.valueOf(model.skuInfo.ugc_cnt));
        detailAssertTest("skuInfo.selled_cnt", String.valueOf(model.skuInfo.selled_cnt));
        //            detailAssertTest("skuInfo.merchant_item_code", model.skuInfo.merchant_item_code);
        detailAssertTest(1, "skuInfo.actived", model.skuInfo.actived);
        detailAssertTest(0, "skuInfo.delete_flag", model.skuInfo.delete_flag);
        detailAssertTest("skuInfo.updated_at", model.skuInfo.updated_at);
        detailAssertTest(2, "skuInfo.audit_status", model.skuInfo.audit_status);
        detailAssertTest(0, "skuInfo.restriction_amount", model.skuInfo.restriction_amount);
        detailAssertTest("skuInfo.fpostage_amount", String.valueOf(model.skuInfo.fpostage_amount));
        detailAssertTest("skuInfo.only_new_user", String.valueOf(model.skuInfo.only_new_user));
        detailAssertTest("skuInfo.version_id", String.valueOf(model.skuInfo.version_id));
        detailAssertTest(true, "skuInfo.canDelivery", model.skuInfo.canDelivery);
        detailAssertTest("skuInfo.pics", model.skuInfo.pics);
        detailAssertTest("", "skuInfo.description", model.skuInfo.description);
        detailAssertTest("skuInfo.labels", model.skuInfo.labels);
        for (int i = 0; i < model.skuInfo.labels.size(); i++) {
            detailAssertTest("skuInfo.labels.get(i).icon", model.skuInfo.labels.get(i).icon);
            detailAssertTest("skuInfo.labels.get(i).text", model.skuInfo.labels.get(i).text);
            detailAssertTest("skuInfo.labels.get(i).link", model.skuInfo.labels.get(i).link);
        }
        detailAssertTest("skuInfo.ugcBrief", String.valueOf(model.skuInfo.ugcBrief));
        detailAssertTest("skuInfo.left_stock", String.valueOf(model.skuInfo.left_stock));
        detailAssertTest("skuInfo.merchantInfo", String.valueOf(model.skuInfo.merchantInfo));
        detailAssertTest("", "skuInfo.merchantInfo.tinyurl", model.skuInfo.merchantInfo.tinyurl);
        detailAssertTest("", "skuInfo.merchantInfo.description", model.skuInfo.merchantInfo.description);
        detailAssertTest("skuInfo.merchantInfo.logo", model.skuInfo.merchantInfo.logo);

        detailAssertTest("skuInfo.merchantInfo.online_sku_cnt", String.valueOf(model.skuInfo.merchantInfo.online_sku_cnt));
        detailAssertTest("skuInfo.merchantInfo.free_delivery_price", String.valueOf(model.skuInfo.merchantInfo.free_delivery_price));
        detailAssertTest("skuInfo.merchantInfo.is_free_delivery", String.valueOf(model.skuInfo.merchantInfo.is_free_delivery));
        detailAssertTest(1, "skuInfo.merchantInfo.enabled", model.skuInfo.merchantInfo.enabled);
        detailAssertTest("skuInfo.merchantInfo.is_free_base_weight", String.valueOf(model.skuInfo.merchantInfo.is_free_base_weight));
        detailAssertTest("", "skuInfo.merchantInfo.vendor_notice", model.skuInfo.merchantInfo.vendor_notice);
        detailAssertTest("", "skuInfo.merchantInfo.udesk_merchant_id", model.skuInfo.merchantInfo.udesk_merchant_id);
//        detailAssertTest("", "skuInfo.merchantInfo.notice", model.skuInfo.merchantInfo.notice);
        detailAssertTest(1, "skuInfo.canBuy", model.skuInfo.canBuy);
        detailAssertTest("价格", "skuInfo.pricePrefix", model.skuInfo.pricePrefix);
        detailAssertTest(100, "skuInfo.maxCartSkuCnt", model.skuInfo.maxCartSkuCnt);
        detailAssertTest("skuInfo.remainderCartSkuCnt", String.valueOf(model.skuInfo.remainderCartSkuCnt));
        detailAssertTest("shareInfo", String.valueOf(model.shareInfo));
        detailAssertTest("shareInfo.firendsZone", String.valueOf(model.shareInfo.firendsZone));
        detailAssertTest("shareInfo.wechat", String.valueOf(model.shareInfo.wechat));
        detailAssertTest("shareInfo.mobileQQ", String.valueOf(model.shareInfo.mobileQQ));
        detailAssertTest("shareInfo.firendsZone.title", model.shareInfo.firendsZone.title);
        detailAssertTest("shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest("shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("shareInfo.wechat.content", model.shareInfo.wechat.content);
        detailAssertTest("shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("schema", model.schema);
        detailAssertTest("h5Link", model.h5Link);


        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("张大爷一号erhao 123", "title", model.title);
            detailAssertTest(1540533600, "startTime", model.startTime);
            detailAssertTest(1735660800, "endTime", model.endTime);
            detailAssertTest(299, "groupPrice", model.groupPrice);
            detailAssertTest(5000, "marketPrice", model.marketPrice);
            detailAssertTest(1735660800, "lotteryTime", model.lotteryTime);
            detailAssertTest(28659, "skuId", model.skuId);
            detailAssertTest(25302, "productId", model.productId);
            detailAssertTest("http://m.beta.haoshiqi.net/#couple_rules?type=2&channel_id=h5&spm=", "ruleUrl", model.ruleUrl);
            detailAssertTest(10099, "singlePrice", model.singlePrice);
            detailAssertTest(1, "skuInfo.source_type", model.skuInfo.source_type);
            detailAssertTest(616, "skuInfo.merchant_id", model.skuInfo.merchant_id);
            detailAssertTest(25302, "skuInfo.product_id", model.skuInfo.product_id);
            detailAssertTest("接口测试专用商品，勿动动", "skuInfo.name", model.skuInfo.name);
            detailAssertTest(100, "skuInfo.weight", model.skuInfo.weight);
            detailAssertTest(1900, "skuInfo.price", model.skuInfo.price);
            detailAssertTest("http://img2.haoshiqi.net/ma32483124920c8aea275a83545aa3b5aa.jpg", "skuInfo.thumbnail", model.skuInfo.thumbnail);
            detailAssertTest(5000, "skuInfo.market_price", model.skuInfo.market_price);
            detailAssertTest(1900, "skuInfo.lowest_price", model.skuInfo.lowest_price);
            detailAssertTest(1523873005, "skuInfo.seller_time", model.skuInfo.seller_time);
            detailAssertTest(1833552000, "skuInfo.expired_date", model.skuInfo.expired_date);
            detailAssertTest(1522512000, "skuInfo.manufactured_date", model.skuInfo.manufactured_date);

            detailAssertTest(1523872988, "skuInfo.created_at", model.skuInfo.created_at);
            detailAssertTest(1523873005, "skuInfo.audit_time", model.skuInfo.audit_time);
            detailAssertTest(1523873005, "skuInfo.online_time", model.skuInfo.online_time);
            detailAssertTest("pin", "skuInfo.feature", model.skuInfo.feature);
            detailAssertTest(1000, "skuInfo.lowest_web_price", model.skuInfo.lowest_web_price);
            detailAssertTest("保质期", "skuInfo.attrs.get(0).name", model.skuInfo.attrs.get(0).name);
            detailAssertTest("2018/04/01生产-2028/02/08到期", "skuInfo.attrs.get(0).value", model.skuInfo.attrs.get(0).value);

            detailAssertTest("保质期", "skuInfo.attrOptions.get(0).name", model.skuInfo.attrOptions.get(0).name);
            detailAssertTest("2018/04/01-2028/02/08", "skuInfo.attrOptions.get(0).list.get(0).value", model.skuInfo.attrOptions.get(0).list.get(0).value);
            detailAssertTest(28659, "skuInfo.attrOptions.get(0).list.get(0).skuId", model.skuInfo.attrOptions.get(0).list.get(0).skuId);

            detailAssertTest("1833552000", "skuInfo.batch", model.skuInfo.batch);
            detailAssertTest(2592000, "skuInfo.offline_before_expired", model.skuInfo.offline_before_expired);

            detailAssertTest(28659, "skuInfo.skuId", model.skuInfo.skuId);
            detailAssertTest(25302, "skuInfo.productId", model.skuInfo.productId);
            detailAssertTest(616, "skuInfo.merchantId", model.skuInfo.merchantId);
            detailAssertTest(616, "skuInfo.merchantInfo.id", model.skuInfo.merchantInfo.id);
            detailAssertTest(9, "skuInfo.merchantInfo.roles", model.skuInfo.merchantInfo.roles);
            detailAssertTest("蜜我食铺", "skuInfo.merchantInfo.name", model.skuInfo.merchantInfo.name);
            detailAssertTest("上海", "skuInfo.merchantInfo.province", model.skuInfo.merchantInfo.province);
            detailAssertTest("上海市", "skuInfo.merchantInfo.city", model.skuInfo.merchantInfo.city);

        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {

            detailAssertTest("压测抽奖活动（勿动）", "title", model.title);
            detailAssertTest(1557367800, "startTime", model.startTime);
            detailAssertTest(2051193600, "endTime", model.endTime);
            detailAssertTest(1, "groupPrice", model.groupPrice);
            detailAssertTest(3, "marketPrice", model.marketPrice);
            detailAssertTest(2051193600, "lotteryTime", model.lotteryTime);
            detailAssertTest(85486, "skuId", model.skuId);
            detailAssertTest(70743, "productId", model.productId);
            detailAssertTest("https://m.haoshiqi.net/#couple_rules?type=2&channel_id=h5&spm=", "ruleUrl", model.ruleUrl);
            detailAssertTest(2, "singlePrice", model.singlePrice);
            detailAssertTest(1, "skuInfo.source_type", model.skuInfo.source_type);
            detailAssertTest(1786, "skuInfo.merchant_id", model.skuInfo.merchant_id);
            detailAssertTest(70743, "skuInfo.product_id", model.skuInfo.product_id);
            detailAssertTest("压测专用（勿动） 200g", "skuInfo.name", model.skuInfo.name);
            detailAssertTest(0, "skuInfo.weight", model.skuInfo.weight);
            detailAssertTest(3, "skuInfo.price", model.skuInfo.price);
            detailAssertTest("http://img2.haoshiqi.net/maaa938eac8efc626a53e043574c88cdc9.jpg", "skuInfo.thumbnail", model.skuInfo.thumbnail);
            detailAssertTest(3, "skuInfo.market_price", model.skuInfo.market_price);
            detailAssertTest(3, "skuInfo.lowest_price", model.skuInfo.lowest_price);
            detailAssertTest(1557365804, "skuInfo.seller_time", model.skuInfo.seller_time);
            detailAssertTest(2127312000, "skuInfo.expired_date", model.skuInfo.expired_date);
            detailAssertTest(778348800, "skuInfo.manufactured_date", model.skuInfo.manufactured_date);

            detailAssertTest(1557365778, "skuInfo.created_at", model.skuInfo.created_at);
            detailAssertTest(1557365804, "skuInfo.audit_time", model.skuInfo.audit_time);
            detailAssertTest(1557365804, "skuInfo.online_time", model.skuInfo.online_time);
            detailAssertTest("pin,gift", "skuInfo.feature", model.skuInfo.feature);
            detailAssertTest(3, "skuInfo.lowest_web_price", model.skuInfo.lowest_web_price);
            detailAssertTest("保质期", "skuInfo.attrs.get(0).name", model.skuInfo.attrs.get(0).name);
            detailAssertTest("1994/09/01生产-2037/05/31到期", "skuInfo.attrs.get(0).value", model.skuInfo.attrs.get(0).value);
            detailAssertTest("规格", "skuInfo.attrs.get(1).name", model.skuInfo.attrs.get(1).name);
            detailAssertTest("200g", "skuInfo.attrs.get(1).value", model.skuInfo.attrs.get(1).value);


            detailAssertTest("保质期", "skuInfo.attrOptions.get(0).name", model.skuInfo.attrOptions.get(0).name);
            detailAssertTest("1994/09/01-2037/05/31", "skuInfo.attrOptions.get(0).list.get(0).value", model.skuInfo.attrOptions.get(0).list.get(0).value);
            detailAssertTest(85486, "skuInfo.attrOptions.get(0).list.get(0).skuId", model.skuInfo.attrOptions.get(0).list.get(0).skuId);

            detailAssertTest("规格", "skuInfo.attrOptions.get(1).name", model.skuInfo.attrOptions.get(1).name);
            detailAssertTest("200g", "skuInfo.attrOptions.get(1).list.get(0).value", model.skuInfo.attrOptions.get(1).list.get(0).value);
            detailAssertTest(85486, "skuInfo.attrOptions.get(1).list.get(0).skuId", model.skuInfo.attrOptions.get(1).list.get(0).skuId);

            detailAssertTest("2127312000", "skuInfo.batch", model.skuInfo.batch);
            detailAssertTest(2592000, "skuInfo.offline_before_expired", model.skuInfo.offline_before_expired);
            detailAssertTest(85486, "skuInfo.skuId", model.skuInfo.skuId);
            detailAssertTest(70743, "skuInfo.productId", model.skuInfo.productId);
            detailAssertTest(1786, "skuInfo.merchantId", model.skuInfo.merchantId);
            detailAssertTest(1786, "skuInfo.merchantInfo.id", model.skuInfo.merchantInfo.id);
            detailAssertTest(1, "skuInfo.merchantInfo.roles", model.skuInfo.merchantInfo.roles);
            detailAssertTest("淘食铺", "skuInfo.merchantInfo.name", model.skuInfo.merchantInfo.name);
            detailAssertTest("北京", "skuInfo.merchantInfo.province", model.skuInfo.merchantInfo.province);
            detailAssertTest("北京市", "skuInfo.merchantInfo.city", model.skuInfo.merchantInfo.city);


        }


    }

}
