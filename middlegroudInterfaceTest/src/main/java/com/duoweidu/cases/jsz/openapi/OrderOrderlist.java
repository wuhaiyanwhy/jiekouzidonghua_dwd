package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;


public class OrderOrderlist extends JszInterfaceTest {

    public void orderOrderlist(String status) {
        setUrl("order.orderlist.uri");
        param = "status="+ status;
        process(true, false);
    }

    @Test(description = "1全部订单")
    public void orderOrderlist1() {
        orderOrderlist("1");
    }

    @Test(description = "2待付款")
    public void orderOrderlist2() {
        orderOrderlist("2");
    }

    @Test(description = "3待使用")
    public void orderOrderlist3() {
        orderOrderlist("3");
    }

    @Test(description = "4已使用")
    public void orderOrderlist4() {
        orderOrderlist("4");
    }

    @Test(description = "5已过期")
    public void orderOrderlist5() {
        orderOrderlist("5");
    }

    @Test(description = "6已取消")
    public void orderOrderlist6() {
        orderOrderlist("6");
    }

    @Test(description = "7已退款")
    public void orderOrderlist7() {
        orderOrderlist("7");
    }
}
