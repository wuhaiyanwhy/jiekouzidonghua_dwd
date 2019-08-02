package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;


public class product_browseskulist_test extends HsqInterfaceTest {

    @Test(description = "浏览记录")
    public void product_browseskulist_true() {
        setUrl("product.browseskulist.uri");
        param = "browseRecords=28581:12345";
        process(false,false);
        statusAssertTest();
    }
}
