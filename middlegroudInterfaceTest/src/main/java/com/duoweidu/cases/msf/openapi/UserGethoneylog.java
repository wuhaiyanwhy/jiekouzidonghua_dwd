package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserGethoneylog extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜日志")
    public void userGethoneylog() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_GETHONEYLOG);
        param = "page_num=1&page_limit=20";
        process(true,true);
    }
}
