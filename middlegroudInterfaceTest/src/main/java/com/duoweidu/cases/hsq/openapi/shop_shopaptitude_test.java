package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ShopShopaptitudeData;
import org.testng.annotations.Test;

public class shop_shopaptitude_test extends HsqInterfaceTest {

    private ShopShopaptitudeData model;

    @Test(dependsOnGroups = "loginTrue",description = "工商资质")
    public void shop_shopaptitude_true() {
        setUrl("shop.shopaptitude.uri");
        param = "&merchantId=" + SqlDetail.getInstance().getParamValue("merchantId");
        process(true,false);
        model = sparseJson(ShopShopaptitudeData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("merchantId", model.merchantId);
        detailAssertTest("title", model.title);
        detailAssertTest("content", model.content);
    }

}
