package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.model.Interface.ZhimaZhimaskudetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class ZhimaZhimaskudetail extends HsqInterfaceTest {

    private ZhimaZhimaskudetailData model;

    @Test(description = "芝麻商品详情页")
    public void zhimaZhimaskudetail() {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.ZHIMA_ZHIMASKUDETAIL);
        param = "token=" + SqlDetail.getParamValue("token") +
                "&zhimaId=" + SqlDetail.getParamValue("zhimaId", 2);
        process(true,false);
        model = sparseJson(ZhimaZhimaskudetailData.class);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(34548, "id", model.id);
        detailAssertTest(1, "source_type", model.source_type);
        detailAssertTest(616, "merchant_id", model.merchant_id);
        detailAssertTest(28755, "product_id", model.product_id);
        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "name", model.name);
        detailAssertTest("weight", String.valueOf(model.weight));
        detailAssertTest(6666, "price", model.price);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg?imageView2/0/w/200/h/200/q/70", "thumbnail", model.thumbnail);
        detailAssertTest(8888, "market_price", model.market_price);
        detailAssertTest(6666, "lowest_price", model.lowest_price);
        detailAssertTest(1560847502, "seller_time", model.seller_time);
        detailAssertTest("2537539200", "expired_date", model.expired_date);
        detailAssertTest("973008000", "manufactured_date", model.manufactured_date);
        detailAssertTest(1, "enabled", model.enabled);
        detailAssertTest("liked_cnt", String.valueOf(model.liked_cnt));
        detailAssertTest("ugc_cnt", String.valueOf(model.ugc_cnt));
        detailAssertTest("selled_cnt", String.valueOf(model.selled_cnt));

        detailAssertTest("", "merchant_item_code", model.merchant_item_code);
        detailAssertTest(1, "actived", model.actived);
        detailAssertTest(0, "delete_flag", model.delete_flag);
        detailAssertTest(1560847388, "created_at", model.created_at);
        detailAssertTest(1560848323, "updated_at", model.updated_at);
        detailAssertTest(2, "audit_status", model.audit_status);
        detailAssertTest(1560847502, "audit_time", model.audit_time);
        detailAssertTest(0, "restriction_amount", model.restriction_amount);
        detailAssertTest(0, "fpostage_amount", model.fpostage_amount);
        detailAssertTest(1560847502, "online_time", model.online_time);
        detailAssertTest(0, "only_new_user", model.only_new_user);
        detailAssertTest("pin,zhima", "feature", model.feature);
        detailAssertTest(8888, "lowest_web_price", model.lowest_web_price);
        detailAssertTest("version_id", model.version_id);
        detailAssertTest("保质期", "attrs.get(0).name", model.attrs.get(0).name);
        detailAssertTest("2000/11/01生产-2050/05/31到期", "attrs.get(0).value", model.attrs.get(0).value);
        detailAssertTest("规格", "attrs.get(1).name", model.attrs.get(1).name);
        detailAssertTest("100g", "attrs.get(1).value", model.attrs.get(1).value);

        detailAssertTest(76, "zhima_id", model.zhima_id);
        detailAssertTest(34548, "sku_id", model.sku_id);
        detailAssertTest(10999, "show_price", model.show_price);
        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "zm_sku_name", model.zm_sku_name);
        detailAssertTest(2, "row_status", model.row_status);
        detailAssertTest(1, "enable", model.enable);
        detailAssertTest(973008000, "start_time", model.start_time);
        detailAssertTest(2147483647, "end_time", model.end_time);
        detailAssertTest(12595, "pin_id", model.pin_id);
        detailAssertTest("5", "discount", model.discount);
        detailAssertTest(50, "discount_percent", model.discount_percent);
        detailAssertTest("信用专惠享5折", "discount_text", model.discount_text);
        detailAssertTest(true, "skuIsOnline", model.skuIsOnline);
        detailAssertTest(5500, "zhima_price", model.zhima_price);
        detailAssertTest(1, "participate_status", model.participate_status);
        detailAssertTest("", "promotionName", model.promotionName);
        detailAssertTest(true, "canBuy", model.canBuy);
        detailAssertTest(true, "canDelivery", model.canDelivery);
        detailAssertTest("", "deliveryWayName", model.deliveryWayName);
        detailAssertTest("2537539200", "batchOptions.get(0).batch", model.batchOptions.get(0).batch);
        detailAssertTest(34548, "batchOptions.get(0).skuId", model.batchOptions.get(0).skuId);
        detailAssertTest(6666, "batchOptions.get(0).price", model.batchOptions.get(0).price);
        detailAssertTest("2537539200", "batchOptions.get(0).expired_date", model.batchOptions.get(0).expired_date);
        detailAssertTest("973008000", "batchOptions.get(0).manufactured_date", model.batchOptions.get(0).manufactured_date);
        detailAssertTest("1560847502", "batchOptions.get(0).seller_time", model.batchOptions.get(0).seller_time);
        detailAssertTest(6666, "batchOptions.get(0).lowest_price", model.batchOptions.get(0).lowest_price);
        detailAssertTest(2592000, "batchOptions.get(0).offline_before_expired", model.batchOptions.get(0).offline_before_expired);

        detailAssertTest("attrOptions", model.attrOptions);
        detailAssertTest("保质期", "attrOptions.get(0).name", model.attrOptions.get(0).name);
        detailAssertTest("attrOptions.get(0).list", model.attrOptions.get(0).list);
        detailAssertTest("2000/11/01-2050/05/31", "attrOptions.get(0).list.get(0).value", model.attrOptions.get(0).list.get(0).value);
        detailAssertTest(34548, "attrOptions.get(0).list.get(0).skuId", model.attrOptions.get(0).list.get(0).skuId);

        detailAssertTest("规格", "attrOptions.get(1).name", model.attrOptions.get(1).name);
        detailAssertTest("100g", "attrOptions.get(1).list.get(0).value", model.attrOptions.get(1).list.get(0).value);
        detailAssertTest(34548, "attrOptions.get(1).list.get(0).skuId", model.attrOptions.get(1).list.get(0).skuId);


        detailAssertTest("2537539200", "batch", model.batch);
        detailAssertTest(1, "sourceType", model.sourceType);
        detailAssertTest(34548, "skuId", model.skuId);
        detailAssertTest(28755, "productId", model.productId);
        detailAssertTest(616, "merchantId", model.merchantId);
        detailAssertTest("left_stock", model.left_stock);
        detailAssertTest(2592000, "offline_before_expired", model.offline_before_expired);
        detailAssertTest("", "description", model.description);
        detailAssertTest(false, "is_like", model.is_like);
        detailAssertTest("pics", model.pics);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg?imageView2/0/w/840/h/840/q/70", "pics.get(0)", model.pics.get(0));
        detailAssertTest( "http://img2.haoshiqi.net/maefe678e4531abc17a8295e0a610e8198.jpg?imageView2/0/w/840/h/840/q/70", "pics.get(1)", model.pics.get(1));
        detailAssertTest("labels", model.labels);
        detailAssertTest(616, "merchantInfo.id", model.merchantInfo.id);
        detailAssertTest("蜜我食铺", "merchantInfo.name", model.merchantInfo.name);
        detailAssertTest("http://img2.haoshiqi.net/ma17de1c5d5369f354d8b24a3458319d93?imageView2/0/w/200/h/200/q/70", "merchantInfo.logo", model.merchantInfo.logo);
        detailAssertTest("haoshiqi://hybrid?compid=haoshiqi&comppage=merchant&merchantid=616", "merchantInfo.schema", model.merchantInfo.schema);

        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("http://m.haoshiqi.net/index.html#detail?sid=34548&spm=hsq_unknown","model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("【好食期特惠-限时限量】接口自动化测试专用商品（勿动） 100g", "model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest(false, "shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
        detailAssertTest("", "shareInfo.wechat.userName", model.shareInfo.wechat.userName);
        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("http://m.haoshiqi.net/index.html#detail?sid=34548&spm=hsq_unknown", "model.shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("好食期特惠，原价￥88.88，仅售￥66.66-66.66，限时限量哦！", "model.shareInfo.wechat.content", model.shareInfo.wechat.content);

        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("http://m.haoshiqi.net/index.html#detail?sid=34548&spm=hsq_unknown", "model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("好食期特惠，原价￥88.88，仅售￥66.66-66.66，限时限量哦！", "model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("接口自动化测试专用商品（勿动） 100g", "shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("http://img2.haoshiqi.net/ma775648f49d5b7fc726fbe01d8a2325f2.jpg", "model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
        detailAssertTest("http://m.haoshiqi.net/index.html#detail?sid=34548&spm=hsq_unknown", "model.shareInfo.alipay.link", model.shareInfo.alipay.link);
        detailAssertTest("好食期特惠，原价￥88.88，仅售￥66.66-66.66，限时限量哦！", "model.shareInfo.alipay.content", model.shareInfo.alipay.content);


        detailAssertTest(100, "maxCartSkuCnt", model.maxCartSkuCnt);
        detailAssertTest(100, "remainderCartSkuCnt", model.remainderCartSkuCnt);
        detailAssertTest(34548, "skuIds", model.skuIds);
        detailAssertTest("价格", "pricePrefix", model.pricePrefix);
//        detailAssertTest("activity_list", model.activity_list);
//        detailAssertTest(119, "activity_list.get(0).activity_id", model.activity_list.get(0).activity_id);
//        detailAssertTest("多买多省", "activity_list.get(0).activity_name", model.activity_list.get(0).activity_name);
//        detailAssertTest("接口自动化测试专用套餐（勿动）", "activity_list.get(0).real_name", model.activity_list.get(0).real_name);
//        detailAssertTest("ZMCS02201906190100360001259764", "activity_list.get(0).activity_no", model.activity_list.get(0).activity_no);
//        detailAssertTest(2, "activity_list.get(0).rule_type", model.activity_list.get(0).rule_type);
//        detailAssertTest("{\"day\":\"15\",\"amount\":0,\"times\":\"3\"}", "activity_list.get(0).rules", model.activity_list.get(0).rules);
//        detailAssertTest(50, "activity_list.get(0).discount", model.activity_list.get(0).discount);
//        detailAssertTest("15天消费3单", "activity_list.get(0).consumed_rules", model.activity_list.get(0).consumed_rules);

    }
}
