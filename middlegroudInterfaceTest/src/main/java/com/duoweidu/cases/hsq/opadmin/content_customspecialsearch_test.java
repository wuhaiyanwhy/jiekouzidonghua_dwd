package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_customspecialsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "自定义专题搜索")
    public void content_customspecialsearch_true() {

        setUrl("content.customspecialsearch.uri");
        process(false,false);

    }
}
