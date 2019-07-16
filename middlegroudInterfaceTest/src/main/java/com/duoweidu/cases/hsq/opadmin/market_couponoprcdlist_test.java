package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_couponoprcdlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "优惠券使用明细列表")
    public void market_couponoprcdlist_true() {
        setUrl("market.couponoprcdlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,false,false);

    }
}
