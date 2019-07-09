package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonAppconfig extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "app初始化配置")
    public void commonAppconfig() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_APPCONFIG);
        param = "platform=" + TestSql.getValue("platform",4);
        process(true,false);
    }

}
