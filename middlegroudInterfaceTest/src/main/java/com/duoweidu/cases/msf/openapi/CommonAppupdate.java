package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class CommonAppupdate extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "app更新")
    public void commonAppupdate() {
        setUrl("common.appupdate.uri");
        process(true,false);
    }
}
