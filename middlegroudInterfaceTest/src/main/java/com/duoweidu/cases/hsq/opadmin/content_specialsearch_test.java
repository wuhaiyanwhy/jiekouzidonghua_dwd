package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class content_specialsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "专题推荐搜索")
    public void content_specialsearch_true() {

        setUrl("content.specialsearch.uri");
        process(false,false);

    }
}
