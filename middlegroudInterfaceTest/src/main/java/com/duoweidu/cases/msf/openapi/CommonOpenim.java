package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonOpenim extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取Udesk参数")
    public void commonOpenim() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_OPENIM);
        process(true,false);
    }
}
