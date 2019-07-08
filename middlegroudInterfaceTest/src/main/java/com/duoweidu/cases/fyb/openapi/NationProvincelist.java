package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class NationProvincelist extends FybInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取省份列表")
    public void nationProvincelist() {
        setUrl("nation.provincelist.uri");
        process(true,true);
    }
}
