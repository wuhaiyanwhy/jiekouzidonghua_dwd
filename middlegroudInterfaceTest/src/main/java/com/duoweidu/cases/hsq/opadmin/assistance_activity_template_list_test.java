package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class assistance_activity_template_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "助力免单分享模板列表")
    public void assistance_activity_template_list_true() {

        setUrl("assistance.activity.template.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
