package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class nation_provincelist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取省份列表")
    public void nation_provincelist_true() {
        setUrl("nation.provincelist.uri");
        process(true,true);
    }

}
