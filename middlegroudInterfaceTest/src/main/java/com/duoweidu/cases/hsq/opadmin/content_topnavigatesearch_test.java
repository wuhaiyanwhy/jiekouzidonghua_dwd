package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_topnavigatesearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "导航管理搜索")
    public void content_topnavigatesearch_true() {
        setUrl("content.topnavigatesearch.uri");
        process(false,false);

    }
}
