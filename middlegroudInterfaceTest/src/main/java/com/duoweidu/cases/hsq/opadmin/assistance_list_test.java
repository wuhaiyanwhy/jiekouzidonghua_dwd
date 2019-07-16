package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class assistance_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "助力免单活动管理")
    public void assistance_list_true() {

        setUrl("assistance.list.uri");
        process(false,false);

    }
}
