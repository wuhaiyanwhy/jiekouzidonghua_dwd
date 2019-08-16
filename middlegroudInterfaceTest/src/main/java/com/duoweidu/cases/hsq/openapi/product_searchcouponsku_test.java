package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ProductSearchcouponskuData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class product_searchcouponsku_test extends HsqInterfaceTest {

    private ProductSearchcouponskuData model;

    @Test(description = "优惠券搜索")
    public void product_searchcouponsku_true() {
        setUrl("product.searchcouponsku.uri");
        param = "couponId=2805&q=测试";
        process(true,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(ProductSearchcouponskuData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).skuInfo.manufactured_date", model.list.get(i).skuInfo.manufactured_date);
            detailAssertTest("list.get(i).skuInfo.lowest_price", model.list.get(i).skuInfo.lowest_price);
            detailAssertTest("list.get(i).skuInfo.created_at", model.list.get(i).skuInfo.created_at);
            detailAssertTest("list.get(i).skuInfo.merchant_id", model.list.get(i).skuInfo.merchant_id);
            detailAssertTest("list.get(i).skuInfo.enabled", model.list.get(i).skuInfo.enabled);
            detailAssertTest("list.get(i).skuInfo.price", model.list.get(i).skuInfo.price);
            detailAssertTest("list.get(i).skuInfo.product_id", model.list.get(i).skuInfo.product_id);
            detailAssertTest("list.get(i).skuInfo.offline_before_expired", model.list.get(i).skuInfo.offline_before_expired);
            detailAssertTest("list.get(i).skuInfo.skuId", model.list.get(i).skuInfo.skuId);
            detailAssertTest("list.get(i).skuInfo.thumbnail", model.list.get(i).skuInfo.thumbnail);
            detailAssertTest("list.get(i).skuInfo.product_name", model.list.get(i).skuInfo.product_name);
            detailAssertTest("list.get(i).skuInfo.expired_date", model.list.get(i).skuInfo.expired_date);
            detailAssertTest("list.get(i).skuInfo.seller_time", model.list.get(i).skuInfo.seller_time);
            detailAssertTest("list.get(i).skuInfo.thumbnail", model.list.get(i).skuInfo.thumbnail);
            detailAssertTest("list.get(i).skuInfo.product_name", model.list.get(i).skuInfo.product_name);
            detailAssertTest("list.get(i).skuInfo.expired_date", model.list.get(i).skuInfo.expired_date);
            detailAssertTest("list.get(i).skuInfo.seller_time", model.list.get(i).skuInfo.seller_time);
            if (model.list.get(i).skuInfo.attrs.size() > 0) {
                for (int j = 0; j < model.list.get(i).skuInfo.attrs.size(); j++) {
                    detailAssertTest("list.get(i).skuInfo.attrs.get(j).name", model.list.get(i).skuInfo.attrs.get(j).name);
                    detailAssertTest("list.get(i).skuInfo.attrs.get(j).value", model.list.get(i).skuInfo.attrs.get(j).value);
                }
            }

            detailAssertTest("list.get(i).skuInfo.left_stock", String.valueOf(model.list.get(i).skuInfo.left_stock));
            detailAssertTest("list.get(i).skuInfo.name", model.list.get(i).skuInfo.name);
            detailAssertTest("list.get(i).skuInfo.market_price", model.list.get(i).skuInfo.market_price);
            detailAssertTest("list.get(i).skuInfo.lowest_web_price", model.list.get(i).skuInfo.lowest_web_price);
            detailAssertTest("list.get(i).skuInfo.selled_cnt", String.valueOf(model.list.get(i).skuInfo.selled_cnt));
            detailAssertTest("list.get(i).skuInfo.skuPic", model.list.get(i).skuInfo.skuPic);
            detailAssertTest("list.get(i).skuInfo.today_discount", String.valueOf(model.list.get(i).skuInfo.today_discount));
            detailAssertTest("list.get(i).skuInfo.productId", model.list.get(i).skuInfo.productId);
            detailAssertTest("list.get(i).skuInfo.productName", model.list.get(i).skuInfo.productName);
            detailAssertTest("list.get(i).skuInfo.merchant_type", model.list.get(i).skuInfo.merchant_type);
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).id", model.list.get(i).id);



        }
    }
}
