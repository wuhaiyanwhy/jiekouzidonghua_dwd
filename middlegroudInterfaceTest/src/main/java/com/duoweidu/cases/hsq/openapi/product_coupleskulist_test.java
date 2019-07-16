package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class product_coupleskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "二人购商品列表")
    public void product_coupleskulist_true() {
        setUrl("product.coupleskulist.uri");
        process(true,true);
    }

}

