package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;


public class product_iteminfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "单品详情页信息")
    public void product_iteminfo_true() {
        setUrl("product.iteminfo.uri");
        param = "skuId=" + SqlDetail.getParamValue("skuId");
        process(true,false);
    }
}
