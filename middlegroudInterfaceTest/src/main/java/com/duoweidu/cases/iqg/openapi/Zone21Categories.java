package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class Zone21Categories extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页类别")
    public void zone_21_categories_true() {
        setUrl("zone.21.categories.uri");
        process(false,false);
        generalAssertTest(false, true);
    }
}
