package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.OrderNoticepopData;
import org.testng.annotations.Test;

public class OrderNoticepop extends MsfInterfaceTest {

    private OrderNoticepopData model;

    @Test(dependsOnGroups = "loginTrue",description = "订单列表弹窗提示发笔记接口")
    public void orderNoticepop() {
        setUrl("order.noticepop.uri");
        process(true,false);
        model = sparseJson(OrderNoticepopData.class);
        detailAssert();

    }

    private void detailAssert() {
        assertNotNull("is_pop", model.is_pop);
    }
}
