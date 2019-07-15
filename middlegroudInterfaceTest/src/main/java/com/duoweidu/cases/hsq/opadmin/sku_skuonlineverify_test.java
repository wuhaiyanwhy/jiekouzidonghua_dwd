package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class sku_skuonlineverify_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "上架sku审核")
    public void sku_skuonlineverify_true() {

        setUrl("sku.skuonlineverify.uri");
        process(false,false);

    }
}
