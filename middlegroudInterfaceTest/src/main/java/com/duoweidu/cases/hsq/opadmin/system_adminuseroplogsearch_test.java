package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class system_adminuseroplogsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "操作日志搜索")
    public void system_adminuseroplogsearch_true() {

        setUrl("system.adminuseroplogsearch.uri");
        process(false,false);

    }
}
