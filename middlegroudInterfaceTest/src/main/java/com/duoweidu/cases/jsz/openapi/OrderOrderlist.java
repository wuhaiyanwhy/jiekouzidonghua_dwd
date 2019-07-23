package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;


public class OrderOrderlist extends JszInterfaceTest {

    public void orderOrderlist(String status, boolean isList) {
        setUrl("order.orderlist.uri");
        param = "status="+ status;
        process(true, isList);
    }

    @Test(dependsOnGroups = "OrderCreateorder",description = "1全部订单")
    public void orderOrderlist1() {
        if (ConfigFileUrl.getEnv().equals("beta")) {
            orderOrderlist("1", true);
        }
        else if (ConfigFileUrl.getEnv().equals("prod")) {
            orderOrderlist("1", false);
        }

    }

    @Test(dependsOnGroups = "OrderPayorder",groups = "orderOrderlist2",description = "2待付款")
    public void orderOrderlist2() {
        if (ConfigFileUrl.getEnv().equals("beta")) {
            orderOrderlist("2", true);
        }
        else if (ConfigFileUrl.getEnv().equals("prod")) {
            orderOrderlist("2", false);
        }
    }

    @Test(description = "3待使用")
    public void orderOrderlist3() {
        orderOrderlist("3",false);
    }

    @Test(description = "4已使用")
    public void orderOrderlist4() {
        orderOrderlist("4",false);
    }

    @Test(description = "5已过期")
    public void orderOrderlist5() {
        orderOrderlist("5",false);
    }

    @Test(description = "6已取消")
    public void orderOrderlist6() {
        orderOrderlist("6",false);
    }

    @Test(description = "7已退款")
    public void orderOrderlist7() {
        orderOrderlist("7",false);
    }
}
