package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonOpenim extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取Udesk参数")
    public void commonOpenim() {
        setUrl("common.openim.uri");
        process(true,false);
    }
}
