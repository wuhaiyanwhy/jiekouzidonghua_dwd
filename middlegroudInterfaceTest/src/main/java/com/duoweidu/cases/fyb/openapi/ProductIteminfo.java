package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ProductIteminfo extends FybInterfaceTest {

    @Test(description = "产品详情")
    public void productIteminfo() {
        setUrl("product.iteminfo.uri");
        param = "skuId=" + SqlDetail.getParamValue("skuId");
        process(true,false);
    }
}
