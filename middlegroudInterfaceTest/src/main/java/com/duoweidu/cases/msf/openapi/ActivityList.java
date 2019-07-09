package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivityList extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动列表")
    public void ActivityList() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ACTIVITY_LIST);
        process(true,true);
    }
}
