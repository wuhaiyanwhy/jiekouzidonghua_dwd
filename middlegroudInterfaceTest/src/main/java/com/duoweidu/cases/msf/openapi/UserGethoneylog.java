package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class UserGethoneylog extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜日志")
    public void userGethoneylog() {
        setUrl("user.gethoneylog.uri");
        param = "page_num=1&page_limit=20";
        process(true,true);
    }
}
