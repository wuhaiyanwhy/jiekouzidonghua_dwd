package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_logstats_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取idfa")
    public void common_logstats_true() {
        setUrl("common.logstats.uri");
        process(true,false);
    }

}
