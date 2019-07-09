package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonQiniutoken extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取七牛token")
    public void commonQiniutoken() {
        setUrl("common.qiniutoken.uri");
        param = "type=1";
        process(true,false);
    }
}
