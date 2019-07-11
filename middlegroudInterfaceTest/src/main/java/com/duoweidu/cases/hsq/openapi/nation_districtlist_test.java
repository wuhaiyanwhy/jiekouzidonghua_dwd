package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class nation_districtlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取行政区县列表")
    public void nation_districtlist_true() {
        setUrl("nation.districtlist.uri");
        param = "cityId=2";
        process(true,true);
    }

}
