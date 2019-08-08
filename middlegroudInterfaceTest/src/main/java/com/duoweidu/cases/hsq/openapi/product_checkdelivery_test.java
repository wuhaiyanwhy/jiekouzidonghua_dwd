package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class product_checkdelivery_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "loginTrue",description = "检查单品是否符合配送范围")
    public void product_checkdelivery_true() {
        setUrl("product.checkdelivery.uri");
        param = "provinceId=857&skuId=" + SqlDetail.getInstance().getParamValue("skuId");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
