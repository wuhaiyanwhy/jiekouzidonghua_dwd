package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonAppupdate extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "app更新")
    public void commonAppupdate() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_APPUPDATE);
        param = "platform=" + TestSql.getValue("platform",4);
        process(true,false);
    }
}
