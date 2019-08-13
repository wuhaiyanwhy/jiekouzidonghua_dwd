package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ProductCoupleskudetailData;
import com.duoweidu.model.hsq.ProductIteminfoData;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class product_iteminfo_test extends HsqInterfaceTest {

    private ProductIteminfoData model;

    @Test(description = "单品详情页信息")
    public void product_iteminfo_true() {
        setUrl("product.iteminfo.uri");
        param = "skuId=" + SqlDetail.getInstance().getParamValue("skuId");
        process(true,false);
        model = sparseJson(ProductIteminfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("source_type", model.source_type);
        detailAssertTest("merchant_id", model.merchant_id);
        detailAssertTest("product_id", model.product_id);
        detailAssertTest("name", model.name);
//        detailAssertTest("weight", model.weight);
        detailAssertTest("price", model.price);
        detailAssertTest("thumbnail", model.thumbnail);
        detailAssertTest("market_price", model.market_price);
        detailAssertTest("lowest_price", model.lowest_price);
        detailAssertTest("seller_time", model.seller_time);
        detailAssertTest("expired_date", model.expired_date);
        detailAssertTest("manufactured_date", model.manufactured_date);
        detailAssertTest("enabled", model.enabled);
//        detailAssertTest("liked_cnt", model.liked_cnt);
//        detailAssertTest("ugc_cnt", model.ugc_cnt);
//        detailAssertTest("selled_cnt", model.selled_cnt);
//        detailAssertTest("merchant_item_code", model.merchant_item_code);
        detailAssertTest("actived", model.actived);
//        detailAssertTest("delete_flag", model.delete_flag);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest("audit_status", model.audit_status);
        detailAssertTest("audit_time", model.audit_time);
        detailAssertTest("restriction_amount", model.restriction_amount);
//        detailAssertTest("fpostage_amount", model.fpostage_amount);
        detailAssertTest("online_time", model.online_time);
//        detailAssertTest("only_new_user", model.only_new_user);
        detailAssertTest("feature", model.feature);
        detailAssertTest("lowest_web_price", model.lowest_web_price);
//        detailAssertTest("version_id", model.version_id);
        if (model.attrs.size() > 0 ) {
            for (int i = 0; i < model.attrs.size(); i++) {
                detailAssertTest("attrs.get(i).name", model.attrs.get(i).name);
                detailAssertTest("attrs.get(i).value", model.attrs.get(i).value);
            }
        }
//        detailAssertTest("promotionName", model.promotionName);
        detailAssertTest("canBuy", model.canBuy);
        attrKeys(model.attrKeys);
        attrKeys(model.attr_keys);
        attrDatas(model.attr_datas);
        attrDatas(model.attrDatas);
        detailAssertTest("canDelivery", model.canDelivery);
        if (model.batchOptions.size() > 0 ) {
            for (int i = 0; i < model.batchOptions.size(); i++) {
                detailAssertTest("batchOptions.get(i).batch", model.batchOptions.get(i).batch);
                detailAssertTest("batchOptions.get(i).skuId", model.batchOptions.get(i).skuId);
                detailAssertTest("batchOptions.get(i).price", model.batchOptions.get(i).price);
                detailAssertTest("batchOptions.get(i).expired_date", model.batchOptions.get(i).expired_date);
                detailAssertTest("batchOptions.get(i).manufactured_date", model.batchOptions.get(i).manufactured_date);
                detailAssertTest("batchOptions.get(i).seller_time", model.batchOptions.get(i).seller_time);
                detailAssertTest("batchOptions.get(i).lowest_price", model.batchOptions.get(i).lowest_price);
                detailAssertTest("batchOptions.get(i).offline_before_expired", model.batchOptions.get(i).offline_before_expired);
            }
        }
        if (model.attrOptions.size() > 0) {
            for (int i = 0; i < model.attrOptions.size(); i++) {
                detailAssertTest("attrOptions.get(i).name", model.attrOptions.get(i).name);
                detailAssertTest("attrOptions.get(i).list", model.attrOptions.get(i).list);
                for (int j = 0; j < model.attrOptions.get(i).list.size(); j++) {
                    detailAssertTest("attrOptions.get(i).list.get(j).value", model.attrOptions.get(i).list.get(j).value);
                    detailAssertTest("attrOptions.get(i).list.get(j).skuId", model.attrOptions.get(i).list.get(j).skuId);

                }
            }
        }
        detailAssertTest("batch", model.batch);
        detailAssertTest("sourceType", model.sourceType);
        detailAssertTest("skuId", model.skuId);
        detailAssertTest("productId", model.productId);
        detailAssertTest("merchantId", model.merchantId);
        detailAssertTest("left_stock", model.left_stock);
        detailAssertTest("max_cart_nums", model.max_cart_nums);
        detailAssertTest("offline_before_expired", model.offline_before_expired);
        detailAssertTest("is_like", model.is_like);
        detailAssertTest("merchant_type", model.merchant_type);
        detailAssertTest("pics", model.pics);
        for (int i = 0; i < model.labels.size(); i++) {
            detailAssertTest("labels.get(i).icon", model.labels.get(i).icon);
            detailAssertTest("labels.get(i).text", model.labels.get(i).text);
            detailAssertTest("labels.get(i).link", model.labels.get(i).link);
        }
        detailAssertTest("merchantInfo.id", model.merchantInfo.id);
        detailAssertTest("merchantInfo.name", model.merchantInfo.name);
        detailAssertTest("merchantInfo.logo", model.merchantInfo.logo);
        detailAssertTest("merchantInfo.city", model.merchantInfo.city);
        detailAssertTest("merchantInfo.schema", model.merchantInfo.schema);
        detailAssertTest("merchantInfo.promotions", model.merchantInfo.promotions);
        detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest("shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("model.shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("model.shareInfo.wechat.content", model.shareInfo.wechat.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("shareInfo.alipay.title", model.shareInfo.alipay.title);
        detailAssertTest("model.shareInfo.alipay.thumbnail", model.shareInfo.alipay.thumbnail);
        detailAssertTest("model.shareInfo.alipay.link", model.shareInfo.alipay.link);
        detailAssertTest("model.shareInfo.alipay.content", model.shareInfo.alipay.content);
        detailAssertTest("skuIds", model.skuIds);
        detailAssertTest("maxCartSkuCnt", model.maxCartSkuCnt);
        detailAssertTest("remainderCartSkuCnt", model.remainderCartSkuCnt);
        detailAssertTest("pricePrefix", model.pricePrefix);
        detailAssertTest("selectedValue", model.selectedValue);
        detailAssertTest("schema", model.schema);
        detailAssertTest("h5Link", model.h5Link);

    }

    private void attrDatas(HashMap<String, ProductCoupleskudetailData.AttrDatasModel> attr) {
        for (HashMap.Entry<String, ProductCoupleskudetailData.AttrDatasModel> entry : attr.entrySet()) {
            detailAssertTest("attrDatas.id", entry.getValue().id);
            detailAssertTest("attrDatas.source_type", entry.getValue().source_type);
            detailAssertTest("attrDatas.merchant_id", entry.getValue().merchant_id);
            detailAssertTest("attrDatas.product_id", entry.getValue().product_id);
            detailAssertTest("attrDatas.name", entry.getValue().name);
//            detailAssertTest("attrDatas.weight", entry.getValue().weight);
            detailAssertTest("attrDatas.price", entry.getValue().price);
            detailAssertTest("attrDatas.thumbnail", entry.getValue().thumbnail);
            detailAssertTest("attrDatas.market_price", entry.getValue().market_price);
//                detailAssertTest(1900, "attrDatas.lowest_price", entry.getValue().lowest_price);
            detailAssertTest("attrDatas.seller_time", entry.getValue().seller_time);
            detailAssertTest("attrDatas.expired_date", entry.getValue().expired_date);
            detailAssertTest("attrDatas.manufactured_date", entry.getValue().manufactured_date);
            detailAssertTest("attrDatas.enabled", entry.getValue().enabled);
//            detailAssertTest("attrDatas.merchant_item_code", entry.getValue().merchant_item_code);
            detailAssertTest("attrDatas.actived", entry.getValue().actived);
//            detailAssertTest("attrDatas.delete_flag", entry.getValue().delete_flag);
            detailAssertTest("attrDatas.created_at", entry.getValue().created_at);
            detailAssertTest("attrDatas.updated_at", entry.getValue().updated_at);
            detailAssertTest("attrDatas.audit_status", entry.getValue().audit_status);
            detailAssertTest("attrDatas.audit_time", entry.getValue().audit_time);
//            detailAssertTest("attrDatas.restriction_amount", entry.getValue().restriction_amount);
//            detailAssertTest("attrDatas.fpostage_amount", entry.getValue().fpostage_amount);
            detailAssertTest("attrDatas.online_time", entry.getValue().online_time);
//            detailAssertTest("attrDatas.only_new_user", entry.getValue().only_new_user);
            detailAssertTest("attrDatas.feature", entry.getValue().feature);
//                detailAssertTest(1000, "attrDatas.lowest_web_price", entry.getValue().lowest_web_price);
        }


    }

    private void attrKeys(ArrayList<ProductIteminfoData.AttrKeysModel> attrkeys) {
        for (int i = 0; i < attrkeys.size(); i++) {
            detailAssertTest("attrKeys.list", model.attrKeys.get(i).list);
            detailAssertTest("attrKeys.name", model.attrKeys.get(i).name);
            detailAssertTest("attrKeys.defaultAttr", model.attrKeys.get(i).defaultAttr);

        }
    }
}
