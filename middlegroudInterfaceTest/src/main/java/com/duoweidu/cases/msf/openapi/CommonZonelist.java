package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonZonelist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "城市列表")
    public void commonZonelist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_ZONELIST);
        process(true,false);
    }
}
