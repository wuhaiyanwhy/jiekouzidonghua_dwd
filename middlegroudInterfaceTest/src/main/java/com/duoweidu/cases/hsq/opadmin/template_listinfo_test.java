package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class template_listinfo_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页模板配置列表")
    public void template_listinfo_true() {

        setUrl("template.listinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, true, true);
    }
}
