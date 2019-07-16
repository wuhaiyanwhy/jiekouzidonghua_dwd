package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class content_topnavigatelist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "导航管理列表")
    public void content_topnavigatelist_true() {

        setUrl("content.topnavigatelist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,2,true,false);

    }
}
