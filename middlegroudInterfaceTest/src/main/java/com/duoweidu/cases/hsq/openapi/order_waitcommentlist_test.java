package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class order_waitcommentlist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description ="获取用户待评论订单")
    public void order_waitcommentlist_true() {
        setUrl("order.waitcommentlist.uri");
        process(true,false);
    }

}
