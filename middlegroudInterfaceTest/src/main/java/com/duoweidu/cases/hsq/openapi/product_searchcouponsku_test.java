package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class product_searchcouponsku_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "优惠券搜索")
    public void product_searchcouponsku_true() {
        setUrl("product.searchcouponsku.uri");
        param = "couponId=2805&q=测试";
        process(true,false);
    }
}
