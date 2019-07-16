package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class wechattemplate_templateonlinelist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "微信模板消息列表")
    public void wechattemplate_templateonlinelist_true() {

        setUrl("wechattemplate.templateonlinelist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, 2, true, false);
    }
}
