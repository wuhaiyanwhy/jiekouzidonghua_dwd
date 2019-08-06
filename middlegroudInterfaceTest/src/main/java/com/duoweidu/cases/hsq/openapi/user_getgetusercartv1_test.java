package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class user_getgetusercartv1_test extends HsqInterfaceTest {
    @Test(dependsOnGroups = "addskutocart", description = "购物车页面")
    public void user_getgetusercartv1_true(){
        setUrl("user.getusercartv1.uri");
        process(true,true);
    }
}
