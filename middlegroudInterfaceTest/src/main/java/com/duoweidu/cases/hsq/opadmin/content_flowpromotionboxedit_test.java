package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_flowpromotionboxedit_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "非固定推广位")
    public void content_flowpromotionboxedit_true() {

        setUrl("content.flowpromotionboxedit.uri");
        process(false,false);

    }

}
