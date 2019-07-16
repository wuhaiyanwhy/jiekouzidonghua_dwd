package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class wechattemplate_app_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "公众号小程序管理列表")
    public void wechattemplate_app_list_true() {

        setUrl("wechattemplate.app.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, true, true);
    }
}
