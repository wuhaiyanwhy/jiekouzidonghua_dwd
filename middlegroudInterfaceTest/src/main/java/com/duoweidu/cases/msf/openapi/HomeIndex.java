package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class HomeIndex extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页")
    public void homeIndex() {
        setUrl("home.index.uri");
        process(true,false);
    }

}
