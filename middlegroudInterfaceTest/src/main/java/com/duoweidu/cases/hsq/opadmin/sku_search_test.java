package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class sku_search_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "宝贝查询")
    public void sku_search_true() {

        setUrl("sku.search.uri");
        process(false,false);

    }
}
