package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_serviceconfig_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "业务配置")
    public void common_serviceconfig_true() {
        setUrl("common.serviceconfig.uri");
        process(true,false);
    }
}
