package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class product_topicskusinfo_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取专题sku信息")
    public void product_topicskusinfo_true() {
        setUrl("product.topicskusinfo.uri");
        param = "topicCode=" + SqlDetail.getParamValue("topicCode");
        process(true,false);
    }
}
