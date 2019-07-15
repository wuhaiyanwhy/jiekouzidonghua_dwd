package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class alipaytemplate_app_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关联消息模板支付宝列表")
    public void alipaytemplate_app_list_test() {

        setUrl("alipaytemplate.app.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);

    }
}
