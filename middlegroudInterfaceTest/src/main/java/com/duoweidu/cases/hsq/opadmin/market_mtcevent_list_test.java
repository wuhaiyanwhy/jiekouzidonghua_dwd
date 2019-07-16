package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_mtcevent_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "定点消息推送列表(支付宝)")
    public void market_mtcevent_list_true() {

        setUrl("market.mtcevent.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
