package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ProductRecommendproductsData;
import org.testng.annotations.Test;

public class product_recommendproducts_test extends HsqInterfaceTest {

    private ProductRecommendproductsData model;

    @Test(description ="获取推荐商品列表")
    public void product_recommendproducts_true() {
        setUrl("product.recommendproducts.uri");
        process(true,true);
        model = sparseJson(ProductRecommendproductsData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).source_type", model.list.get(i).source_type);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).gc_cate_ids", model.list.get(i).gc_cate_ids);
            detailAssertTest("list.get(i).lowest_price", model.list.get(i).lowest_price);
            detailAssertTest("list.get(i).highest_price", model.list.get(i).highest_price);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).enabled", model.list.get(i).enabled);
            detailAssertTest("list.get(i).package_type", model.list.get(i).package_type);
            detailAssertTest("list.get(i).brand_id", model.list.get(i).brand_id);
            detailAssertTest("list.get(i).offline_before_expired", model.list.get(i).offline_before_expired);
            detailAssertTest("list.get(i).today_discount", model.list.get(i).today_discount);
            detailAssertTest("list.get(i).delivery_time_after_buy", model.list.get(i).delivery_time_after_buy);
//            detailAssertTest("list.get(i).is_migrate", model.list.get(i).is_migrate);
            if (model.list.get(i).tags.size() > 0) {
                for (int j = 0; j < model.list.get(i).tags.size(); j++) {
                    detailAssertTest("list.get(i).tags.get(j).text", model.list.get(i).tags.get(j).text);
                    detailAssertTest("list.get(i).tags.get(j).background", model.list.get(i).tags.get(j).background);

                }
            }
            detailAssertTest("list.get(i).skuInfo.skuId", model.list.get(i).skuInfo.skuId);
            detailAssertTest("list.get(i).skuInfo.skuPic", model.list.get(i).skuInfo.skuPic);
            detailAssertTest("list.get(i).skuInfo.skuThumbnail", model.list.get(i).skuInfo.skuThumbnail);
            if (model.list.get(i).skuInfo.attrs.size() > 0) {
                for (int j = 0; j < model.list.get(i).skuInfo.attrs.size(); j++) {
                    detailAssertTest("list.get(i).skuInfo.name", model.list.get(i).skuInfo.attrs.get(j).name);
                    detailAssertTest("list.get(i).skuInfo.value", model.list.get(i).skuInfo.attrs.get(j).value);
                }
            }
            detailAssertTest("list.get(i).skuInfo.left_stock", String.valueOf(model.list.get(i).skuInfo.left_stock));
            detailAssertTest("list.get(i).skuInfo.id", model.list.get(i).skuInfo.id);
            detailAssertTest("list.get(i).skuInfo.source_type", model.list.get(i).skuInfo.source_type);
            detailAssertTest("list.get(i).skuInfo.merchant_id", model.list.get(i).skuInfo.merchant_id);
            detailAssertTest("list.get(i).skuInfo.product_id", model.list.get(i).skuInfo.product_id);
            detailAssertTest("list.get(i).skuInfo.name", model.list.get(i).skuInfo.name);
            detailAssertTest("list.get(i).skuInfo.price", model.list.get(i).skuInfo.price);
            detailAssertTest("list.get(i).skuInfo.thumbnail", model.list.get(i).skuInfo.thumbnail);
            detailAssertTest("list.get(i).skuInfo.market_price", model.list.get(i).skuInfo.market_price);
            detailAssertTest("list.get(i).skuInfo.lowest_price", model.list.get(i).skuInfo.lowest_price);
            detailAssertTest("list.get(i).skuInfo.seller_time", model.list.get(i).skuInfo.seller_time);
            detailAssertTest("list.get(i).skuInfo.expired_date", model.list.get(i).skuInfo.expired_date);
            detailAssertTest("list.get(i).skuInfo.manufactured_date", model.list.get(i).skuInfo.manufactured_date);
            detailAssertTest("list.get(i).skuInfo.enabled", model.list.get(i).skuInfo.enabled);
            detailAssertTest("list.get(i).skuInfo.actived", model.list.get(i).skuInfo.actived);
            detailAssertTest("list.get(i).skuInfo.created_at", model.list.get(i).skuInfo.created_at);
            detailAssertTest("list.get(i).skuInfo.updated_at", model.list.get(i).skuInfo.updated_at);
            detailAssertTest("list.get(i).skuInfo.audit_status", model.list.get(i).skuInfo.audit_status);
            detailAssertTest("list.get(i).skuInfo.audit_time", model.list.get(i).skuInfo.audit_time);
            detailAssertTest("list.get(i).skuInfo.online_time", model.list.get(i).skuInfo.online_time);
            detailAssertTest("list.get(i).skuInfo.lowest_web_price", model.list.get(i).skuInfo.lowest_web_price);
            detailAssertTest("list.get(i).skuInfo.marketPriceCert", model.list.get(i).skuInfo.marketPriceCert);
            detailAssertTest("list.get(i).skuInfo.marketPriceUrl", model.list.get(i).skuInfo.marketPriceUrl);
            detailAssertTest("list.get(i).skuInfo.updateAt", model.list.get(i).skuInfo.updateAt);
            detailAssertTest("list.get(i).skuInfo.merchantId", model.list.get(i).skuInfo.merchantId);
            detailAssertTest("list.get(i).skuInfo.productId", model.list.get(i).skuInfo.productId);
            detailAssertTest("list.get(i).skuInfo.offline_before_expired", model.list.get(i).skuInfo.offline_before_expired);
            detailAssertTest("list.get(i).skuInfo.sourceType", model.list.get(i).skuInfo.sourceType);
            detailAssertTest("list.get(i).merchantId", model.list.get(i).merchantId);

        }

    }
}
