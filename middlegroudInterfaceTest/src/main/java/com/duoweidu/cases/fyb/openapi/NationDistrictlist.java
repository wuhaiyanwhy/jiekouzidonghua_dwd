package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class NationDistrictlist extends FybInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取行政区县列表")
    public void nationDistrictlist() {
        setUrl("nation.districtlist.uri");
        param = "cityId=2";
        process(true,true);
    }
}
