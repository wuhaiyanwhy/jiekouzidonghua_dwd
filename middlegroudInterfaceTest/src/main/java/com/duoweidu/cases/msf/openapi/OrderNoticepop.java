package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class OrderNoticepop extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单列表弹窗提示发笔记接口")
    public void orderNoticepop() {
        setUrl("order.noticepop.uri");
        process(true,false);

    }
}
