package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class wechattemplate_subscribesmessagepush_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订阅消息推送（微信）")
    public void wechattemplate_subscribesmessagepush_index_true() {

        setUrl("wechattemplate.subscribesmessagepush.index.uri");
        process();
    }
}
