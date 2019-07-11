package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class nation_citylist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取城市列表")
    public void nation_citylist_true() {
        setUrl("nation.citylist.uri");
        param = "provinceId=2";
        process(true,true);
    }
}
