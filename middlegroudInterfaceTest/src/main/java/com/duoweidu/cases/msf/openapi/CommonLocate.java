package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonLocate extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取定位")
    public void commonLocate() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_LOCATE);
        process(true,false);
    }
}
