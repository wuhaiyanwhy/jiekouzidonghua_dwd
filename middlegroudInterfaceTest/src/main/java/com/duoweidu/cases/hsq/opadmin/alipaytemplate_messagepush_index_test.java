package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class alipaytemplate_messagepush_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订单消息推送(支付宝)")
    public void alipaytemplate_messagepush_index_true() {

        setUrl("alipaytemplate.messagepush.index.uri");
        process(false,false);

    }
}
