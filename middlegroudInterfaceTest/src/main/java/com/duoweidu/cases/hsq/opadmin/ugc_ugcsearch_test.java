package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class ugc_ugcsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评论审核搜索")
    public void ugc_ugcsearch_true() {

        setUrl("ugc.ugcsearch.uri");
        process();
    }
}
