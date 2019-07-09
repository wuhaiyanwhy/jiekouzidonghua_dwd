package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonLocate extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取定位")
    public void commonLocate() {
        setUrl("common.locate.uri");
        process(true,false);
    }
}
