package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class Zone extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "城市列表")
    public void zoneTrue() {
        setUrl("zone.uri");
        process(false,false);
        generalAssertTest(true, false);
    }
}
