package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class alipaytemplate_template_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "管理消息模板")
    public void alipaytemplate_template_index_true() {

        setUrl("alipaytemplate.template.index.uri");
        process(false,false);

    }
}
