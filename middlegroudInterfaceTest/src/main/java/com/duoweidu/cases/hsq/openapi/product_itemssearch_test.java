package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 此接口暂时没用到，暂时无需详细断言
 */
public class product_itemssearch_test extends HsqInterfaceTest {

    @Test(description = "普通搜索")
    public void product_itemssearch_true() {
        setUrl("product.itemssearch.uri");
        param = "q=测试";
        process(true,false);
    }
}
