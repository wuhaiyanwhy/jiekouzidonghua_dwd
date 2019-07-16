package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class order_getuserorders_test extends HsqInterfaceTest {

    private void getUserOrders(int type) {
        setUrl("order.getuserorders.uri");
        param = "type=" + type;
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(全部)")
    public void order_getuserorders_quanbuTrue() {
        getUserOrders(0);
        process(true,true);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(待付款)")
    public void order_getuserorders_daifukuanTrue() {
        getUserOrders(1);
        process(true,false);
    }

    @Test(dependsOnGroups = "loginTrue",description ="用户订单列表(待收货)")
    public void order_getuserorders_daishouhuoTrue() {
        getUserOrders(2);
        process(true,false);
    }

}
