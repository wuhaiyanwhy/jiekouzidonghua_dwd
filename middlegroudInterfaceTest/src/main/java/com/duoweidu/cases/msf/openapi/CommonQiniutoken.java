package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonQiniutoken extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取七牛token")
    public void commonQiniutoken() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_QINIUTOKEN);
        param = "type=1";
        process(true,false);
    }
}
