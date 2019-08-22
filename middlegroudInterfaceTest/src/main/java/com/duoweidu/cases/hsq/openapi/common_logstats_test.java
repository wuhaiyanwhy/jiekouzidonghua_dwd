package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ResData;
import org.testng.annotations.Test;

public class common_logstats_test extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "获取idfa")
    public void common_logstats_true() {
        setUrl("common.logstats.uri");
        process(true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
