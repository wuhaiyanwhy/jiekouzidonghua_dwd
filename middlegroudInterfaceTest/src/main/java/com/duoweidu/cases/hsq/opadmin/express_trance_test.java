package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class express_trance_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "物流跟踪")
    public void express_trance_true() {

        setUrl("express.trance.uri");
        process(false,false);

    }
}
