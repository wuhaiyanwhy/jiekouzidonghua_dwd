package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_fixedpromotionboxedit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "固定推广位")
    public void content_fixedpromotionboxedit_true() {

        setUrl("content.fixedpromotionboxedit.uri");
        process(false,false);

    }
}
