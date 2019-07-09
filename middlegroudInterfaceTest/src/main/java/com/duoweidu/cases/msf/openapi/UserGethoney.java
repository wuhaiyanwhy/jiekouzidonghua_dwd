package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserGethoney extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜信息")
    public void userGethoney() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_GETHONEY);
        process(true,false);
    }

}
