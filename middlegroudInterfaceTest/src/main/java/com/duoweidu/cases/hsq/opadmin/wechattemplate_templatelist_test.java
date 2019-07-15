package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class wechattemplate_templatelist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "微信模板消息")
    public void wechattemplate_templatelist_true() {
        setUrl("wechattemplate.templatelist.uri");
        process();
    }

}
