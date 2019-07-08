package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class NationCitylist extends FybInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取城市列表")
    public void nationCitylist() {
        setUrl("nation.citylist.uri");
        param = "provinceId=2";
        process(true,true);
    }
}
