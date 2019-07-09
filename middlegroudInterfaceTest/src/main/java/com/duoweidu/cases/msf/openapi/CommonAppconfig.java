package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonAppconfig extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "app初始化配置")
    public void commonAppconfig() {
        setUrl("common.appconfig.uri");
        process(true,false);
    }

}
