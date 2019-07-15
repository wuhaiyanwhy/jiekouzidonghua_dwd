package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class wechattemplate_template_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关联消息模板列表")
    public void wechattemplate_template_list_true() {

        setUrl("wechattemplate.template.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, true, true);
    }

}
