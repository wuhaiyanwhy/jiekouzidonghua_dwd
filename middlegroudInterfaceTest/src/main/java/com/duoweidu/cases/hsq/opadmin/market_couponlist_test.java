package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_couponlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商家优惠券列表")
    public void market_couponlist_true() {
        setUrl("market.couponlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
