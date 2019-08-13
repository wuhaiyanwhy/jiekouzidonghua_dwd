package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ProductSelfrecommendlistData;
import org.testng.annotations.Test;

public class product_selfrecommendlist_test extends HsqInterfaceTest {

    private ProductSelfrecommendlistData model;

    @Test(description = "个人中心推荐商品")
    public void product_selfrecommendlist_true() {
        setUrl("product.selfrecommendlist.uri");
        param = "pageLimit=20&pageNum=1";
        process(true,true);
        model = sparseJson(ProductSelfrecommendlistData.class);
        detailAssert();
    }

    private void detailAssert() {
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
            detailAssertTest("list.get(i).left_stock", model.list.get(i).left_stock);
            detailAssertTest("list.get(i).all_stock", model.list.get(i).all_stock);
            detailAssertTest("list.get(i).canBought", model.list.get(i).canBought);
            detailAssertTest("list.get(i).onLine", model.list.get(i).onLine);
            detailAssertTest("list.get(i).inStock", model.list.get(i).inStock);

        }
    }
}
