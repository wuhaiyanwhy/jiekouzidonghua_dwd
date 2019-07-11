package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class product_recommendproducts_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取推荐商品列表")
    public void product_recommendproducts_true() {
        setUrl("product.recommendproducts.uri");
        process(true,true);
    }
}
