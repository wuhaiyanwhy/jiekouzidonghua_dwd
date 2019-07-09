package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserArticlelist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "美食笔记列表")
    public void userArticlelist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_ARTICLELIST);
        param = "page_num=1&page_limit=20";
        process(true,false);
    }
}

