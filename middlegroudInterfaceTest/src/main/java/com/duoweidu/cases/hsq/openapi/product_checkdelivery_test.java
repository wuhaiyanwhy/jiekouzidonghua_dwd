package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class product_checkdelivery_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "检查单品是否符合配送范围")
    public void product_checkdelivery_true() {
        setUrl("product.checkdelivery.uri");
        param = "provinceId=857&skuId=" + SqlDetail.getParamValue("skuId");
        process(true,false);
    }
}
