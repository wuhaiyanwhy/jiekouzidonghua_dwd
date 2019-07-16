package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_labelbuttonsearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "标签按钮搜索")
    public void content_labelbuttonsearch_true() {

        setUrl("content.labelbuttonsearch.uri");
        process(false,false);

    }
}
