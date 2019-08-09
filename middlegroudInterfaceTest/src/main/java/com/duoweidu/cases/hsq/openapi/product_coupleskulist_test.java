package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ProductCoupleskulistData;
import org.testng.annotations.Test;

public class product_coupleskulist_test extends HsqInterfaceTest {

    private ProductCoupleskulistData model;

    @Test(description = "二人购商品列表")
    public void product_coupleskulist_true() {
        setUrl("product.coupleskulist.uri");
        process(true,true);
        model = sparseJson(ProductCoupleskulistData.class);
        detailassert();
    }

    private void detailassert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).pinActivitiesId", model.list.get(i).pinActivitiesId);
            detailAssertTest("list.get(i).skuId", model.list.get(i).skuId);
            detailAssertTest("list.get(i).coupleTitle", model.list.get(i).coupleTitle);
            detailAssertTest("list.get(i).couplePrice", model.list.get(i).couplePrice);
            detailAssertTest("list.get(i).productId", model.list.get(i).productId);
            detailAssertTest("list.get(i).marketPrice", model.list.get(i).marketPrice);
            detailAssertTest("list.get(i).expiredDate", model.list.get(i).expiredDate);
            detailAssertTest("list.get(i).skuPic", model.list.get(i).skuPic);
            detailAssertTest("list.get(i).countLimit", model.list.get(i).countLimit);
            detailAssertTest("list.get(i).endTime", model.list.get(i).endTime);
            detailAssertTest("list.get(i).showCountDownLimit", model.list.get(i).showCountDownLimit);
            detailAssertTest("list.get(i).canDelivery", model.list.get(i).canDelivery);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).merchant_type", model.list.get(i).merchant_type);
            detailAssertTest("list.get(i).left_stock", String.valueOf(model.list.get(i).left_stock));
            detailAssertTest("list.get(i).all_stock", model.list.get(i).all_stock);
            if (model.list.get(i).tags.size() > 0) {
                for (int j = 0; j < model.list.get(i).tags.size(); j++) {
                    detailAssertTest("list.get(i).tags.get(j).text", model.list.get(i).tags.get(j).text);
                    detailAssertTest("list.get(i).tags.get(j).background", model.list.get(i).tags.get(j).background);

                }
            }
            detailAssertTest("list.get(i).canBought", model.list.get(i).canBought);
            detailAssertTest("list.get(i).onLine", model.list.get(i).onLine);
            detailAssertTest("list.get(i).inStock", model.list.get(i).inStock);
            detailAssertTest("list.get(i).request_id", model.list.get(i).request_id);

        }
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("totalCnt", model.totalCnt);
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
    }

}

