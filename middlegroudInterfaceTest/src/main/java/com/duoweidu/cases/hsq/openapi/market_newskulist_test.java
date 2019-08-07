package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.MarketNewskulistData;
import org.testng.annotations.Test;

public class market_newskulist_test extends HsqInterfaceTest {

    private MarketNewskulistData model;

    @Test(dependsOnGroups = "loginTrue",description ="今日新品")
    public void market_newskulist_true() {
        setUrl("market.newskulist.uri");
        process(true,true);
        model = sparseJson(MarketNewskulistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("pinActivitiesId", model.list.get(i).pinActivitiesId);
            detailAssertTest("skuId", model.list.get(i).skuId);
            detailAssertTest("coupleTitle", model.list.get(i).coupleTitle);
            detailAssertTest("couplePrice", model.list.get(i).couplePrice);
            detailAssertTest("productId", model.list.get(i).productId);
            detailAssertTest("marketPrice", model.list.get(i).marketPrice);
            detailAssertTest("expiredDate", model.list.get(i).expiredDate);
            detailAssertTest("skuPic", model.list.get(i).skuPic);
            detailAssertTest("countLimit", model.list.get(i).countLimit);
            detailAssertTest("endTime", model.list.get(i).endTime);
            detailAssertTest("showCountDownLimit", model.list.get(i).showCountDownLimit);
            detailAssertTest("canDelivery", model.list.get(i).canDelivery);
            detailAssertTest("merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("merchant_type", model.list.get(i).merchant_type);
//            detailAssertTest("left_stock", model.list.get(i).left_stock);
            detailAssertTest("all_stock", model.list.get(i).all_stock);
            if (model.list.get(i).tags.size() > 0) {
                detailAssertTest("tags", model.list.get(i).tags);
                for (int j = 0; j < model.list.get(i).tags.size(); j++) {
                    detailAssertTest("list.get(i).tags.get(j).text", model.list.get(i).tags.get(j).text);
                    detailAssertTest("list.get(i).tags.get(j).background", model.list.get(i).tags.get(j).background);
                }
            }
            detailAssertTest("canBought", model.list.get(i).canBought);
            detailAssertTest("onLine", model.list.get(i).onLine);
            detailAssertTest("inStock", model.list.get(i).inStock);

        }
    }
}
