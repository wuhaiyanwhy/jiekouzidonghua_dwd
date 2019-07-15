package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class wechat_wechatfanssearch_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "微信服务号粉丝信息获取搜索")
    public void wechat_wechatfanssearch_true() {

        setUrl("wechat.wechatfanssearch.uri");
        process();
    }
}
