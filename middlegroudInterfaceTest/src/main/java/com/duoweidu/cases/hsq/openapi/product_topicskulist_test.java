package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class product_topicskulist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取专题商品列表")
    public void product_topicskulist_true() {
        setUrl("product.topicskulist.uri");
        param = "topicCode=" + SqlDetail.getParamValue("topicCode");
        process(true,false);
    }
}
