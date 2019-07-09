package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonZonelist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "城市列表")
    public void commonZonelist() {
        setUrl("common.zonelist.uri");
        process(true,false);
    }
}
