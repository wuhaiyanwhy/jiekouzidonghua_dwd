package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class alipaytemplate_template_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "管理消息模板列表")
    public void alipaytemplate_template_list_true() {

        setUrl("alipaytemplate.template.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
