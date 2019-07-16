package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_firstorderdiscountlist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首单专享优惠列表")
    public void market_firstorderdiscountlist_true() {
        setUrl("market.firstorderdiscountlist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }

}
