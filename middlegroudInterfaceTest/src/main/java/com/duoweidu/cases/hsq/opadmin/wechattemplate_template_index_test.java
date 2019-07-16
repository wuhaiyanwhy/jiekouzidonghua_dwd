package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;

public class wechattemplate_template_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关联消息模板")
    public void wechattemplate_template_index_true() {

        setUrl("wechattemplate.template.index.uri");
        process();
    }
}
