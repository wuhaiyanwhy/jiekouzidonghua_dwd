package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class ProductCheckbuylimit extends FybInterfaceTest {

    private ResData model;

    @Test(description = "查看限购数量")
    public void productCheckbuylimit() {
        setUrl("product.checkbuylimit.uri");
        param = "skuId=" + SqlDetail.getInstance().getParamValue("skuId");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertTrue("res", model.res);
    }
}
