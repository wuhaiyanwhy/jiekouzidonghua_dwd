package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class wechattemplate_app_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "公众号/小程序管理")
    public void wechattemplate_app_index_true() {

        setUrl("wechattemplate.app.index.uri");
        process();
    }

}
