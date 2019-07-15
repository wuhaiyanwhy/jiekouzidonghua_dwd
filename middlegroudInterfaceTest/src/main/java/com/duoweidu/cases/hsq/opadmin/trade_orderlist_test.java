package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class trade_orderlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单查询列表")
    public void trade_orderlist_true() {

        setUrl("trade.orderlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, 2, true, false);
    }
}
