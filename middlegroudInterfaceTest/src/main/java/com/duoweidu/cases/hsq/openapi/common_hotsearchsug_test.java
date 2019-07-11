package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class common_hotsearchsug_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "搜索热词")
    public void common_hotsearchsug_true() {
        setUrl("common.hotsearchsug.uri");
        process(true,true);
    }

}
