package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class UserGethoney extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜信息")
    public void userGethoney() {
        setUrl("user.gethoney.uri");
        process(true,false);
    }

}
