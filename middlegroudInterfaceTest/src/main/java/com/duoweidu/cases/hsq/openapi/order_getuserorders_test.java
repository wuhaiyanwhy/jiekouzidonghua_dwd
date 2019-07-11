package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class order_getuserorders_test extends HsqInterfaceTest {

    private void getUserOrders(int type) {
        setUrl("order.getuserorders.uri");
        param = "type=" + type;
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(全部)")
    public void order_getuserorders_quanbuTrue() throws IOException {
        getUserOrders(0);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(待付款)")
    public void order_getuserorders_daifukuanTrue() throws IOException {
        getUserOrders(1);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(待收货)")
    public void order_getuserorders_daishouhuoTrue() throws IOException {
        getUserOrders(2);
    }

}
