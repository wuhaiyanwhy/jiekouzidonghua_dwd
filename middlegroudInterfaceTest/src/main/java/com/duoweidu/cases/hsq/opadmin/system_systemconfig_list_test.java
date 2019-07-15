package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_systemconfig_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "后台系统配置列表")
    public void system_systemconfig_list_true() {

        setUrl("system.notice.list.uri");
        process(2,true,false);

    }
}
