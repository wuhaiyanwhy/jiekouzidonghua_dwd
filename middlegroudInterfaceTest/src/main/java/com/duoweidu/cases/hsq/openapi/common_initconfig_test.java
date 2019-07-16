package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_initconfig_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "初始化配置")
    public void common_initconfig_true() {
        setUrl("common.initconfig.uri");
        process(true,false);
    }

}
