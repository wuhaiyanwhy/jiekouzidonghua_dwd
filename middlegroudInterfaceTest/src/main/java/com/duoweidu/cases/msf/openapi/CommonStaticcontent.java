package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommonStaticcontent extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取静态页内容（用户协议）")
    public void commonStaticcontent() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_STATICCONTENT);
        param = "q=terms_of_privacy";
        process(true,false);
    }
}
