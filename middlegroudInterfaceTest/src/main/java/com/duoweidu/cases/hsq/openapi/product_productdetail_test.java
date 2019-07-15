package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ProductProductdetailData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

import java.io.IOException;

public class product_productdetail_test extends HsqInterfaceTest {

    private ProductProductdetailData model;

    @Test(dependsOnGroups = "loginTrue", description = "获取图文详情")
    public void product_productdetail_true() throws IOException {
        setUrl("product.productdetail.uri");
        param = "productId=" + SqlDetail.getInstance().getParamValue("productId");
        process(true,false);
        model = sparseJson(ProductProductdetailData.class);
        generalDetaiAssert();
    }


    private void generalDetaiAssert() throws IOException {
        detailAssertTest(SqlDetail.getInstance().getParamValue("productId"),"id", model.id);
        //有多层josnObject/jsonArray的用法
//        model.subModel.text;
//        model.subModelList.size();
        detailAssertTest(1, "source_type", model.source_type);
        detailAssertTest("1,6,18", "cate_ids", model.cate_ids);
        detailAssertTest(SqlDetail.getInstance().getParamValue("skuId"), "main_sku", model.main_sku);
        detailAssertTest(1, "enabled", model.enabled);
        detailAssertTest(1, "package_type", model.package_type);
        detailAssertTest(0, "restriction_amount", model.restriction_amount);
        detailAssertTest("", "description", model.description);
        detailAssertTest(0, "seller_time", model.seller_time);
        detailAssertTest(0, "weight", model.weight);

        if ("beta".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("接口测试专用商品，勿动动", "name", model.name);
            detailAssertTest("http://img2.haoshiqi.net/ma32483124920c8aea275a83545aa3b5aa.jpg?imageView2/0/q/70","main_sku_pic", model.main_sku_pic);
//            detailAssertTest(999, "lowest_price", model.lowest_price);
            detailAssertTest(1900, "highest_price", model.highest_price);
            detailAssertTest(5000, "market_price", model.market_price);
            detailAssertTest(616, "merchant_id", model.merchant_id);
            detailAssertTest(1570, "brand_id", model.brand_id);
            detailAssertTest("上海市", "producing_area", model.producing_area);
            detailAssertTest(30, "offline_before_expired", model.offline_before_expired);

        }

        if ("prod".equals(ConfigFileUrl.getEnv())) {
            detailAssertTest("压测专用（勿动）", "name", model.name);
            detailAssertTest("http://img2.haoshiqi.net/maaa938eac8efc626a53e043574c88cdc9.jpg?imageView2/0/q/70","main_sku_pic", model.main_sku_pic);
//            detailAssertTest(2, "lowest_price", model.lowest_price);
            detailAssertTest(3, "highest_price", model.highest_price);
            detailAssertTest(2, "market_price", model.market_price);
            detailAssertTest(1786, "merchant_id", model.merchant_id);
            detailAssertTest(6002, "brand_id", model.brand_id);
            detailAssertTest("上海市", "producing_area", model.producing_area);
            detailAssertTest(30, "offline_before_expired", model.offline_before_expired);

        }

    }
}
