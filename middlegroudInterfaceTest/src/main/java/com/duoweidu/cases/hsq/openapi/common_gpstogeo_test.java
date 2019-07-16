package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_gpstogeo_test extends HsqInterfaceTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取地理位置信息")
    public void common_gpstogeo_true() {
        setUrl("common.gpstogeo.uri");
        param = "aMapId=021";
        process(true,false);
    }

}
