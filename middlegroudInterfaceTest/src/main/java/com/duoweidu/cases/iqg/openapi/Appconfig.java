package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class Appconfig extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "配置")
    public void appconfig_true() {
        setUrl("appconfig.uri");
        process(true,false);
    }
}
