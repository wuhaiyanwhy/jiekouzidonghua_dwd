package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class ProductCheckbuylimit extends FybInterfaceTest {

    @Test(description = "查看限购数量")
    public void productCheckbuylimit() {
        setUrl("product.checkbuylimit.uri");
        param = "skuId=" + SqlDetail.getParamValue("skuId");
        process(true,false);
    }
}
