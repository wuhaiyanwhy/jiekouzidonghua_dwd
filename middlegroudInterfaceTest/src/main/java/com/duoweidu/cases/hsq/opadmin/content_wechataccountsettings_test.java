package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_wechataccountsettings_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人微信号设置")
    public void content_wechataccountsettings_true() {

        setUrl("content.wechataccountsettings.uri");
        process(false,false);

    }
}
