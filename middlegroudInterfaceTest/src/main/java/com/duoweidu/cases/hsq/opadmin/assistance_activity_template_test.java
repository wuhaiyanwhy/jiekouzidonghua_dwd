package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class assistance_activity_template_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "助力免单分享模板")
    public void assistance_activity_template_true() {

        setUrl("assistance.activity.template.uri");
        process(false,false);

    }
}
