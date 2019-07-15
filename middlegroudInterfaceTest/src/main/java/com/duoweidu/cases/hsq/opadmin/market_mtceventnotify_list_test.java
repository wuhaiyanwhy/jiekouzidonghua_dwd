package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_mtceventnotify_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息推送管理列表")
    public void market_mtceventnotify_list_true() {

        setUrl("market.mtceventnotify.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
