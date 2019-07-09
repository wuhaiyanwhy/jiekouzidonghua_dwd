package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class BranchNearcbd extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "地理位置")
    public void branchNearcbd() {
        setUrl("branch.nearcbd.uri");
        process(true,false);
    }
}
