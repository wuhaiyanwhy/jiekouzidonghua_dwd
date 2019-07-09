package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeIndex extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页")
    public void homeIndex() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.HOME_INDEX);
        process(true,false);
    }

}
