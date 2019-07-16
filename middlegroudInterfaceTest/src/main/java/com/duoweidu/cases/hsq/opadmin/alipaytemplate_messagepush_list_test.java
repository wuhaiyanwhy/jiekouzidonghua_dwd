package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class alipaytemplate_messagepush_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单消息推送列表(支付宝)")
    public void alipaytemplate_messagepush_list_true() {

        setUrl("alipaytemplate.messagepush.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
