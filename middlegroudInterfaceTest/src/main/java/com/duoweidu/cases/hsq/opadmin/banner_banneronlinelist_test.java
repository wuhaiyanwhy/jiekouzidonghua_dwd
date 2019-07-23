package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class banner_banneronlinelist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页banner列表")
    public void banner_banneronlinelist_true() {

        setUrl("banner.banneronlinelist.uri");
        List<NameValuePair> list =  new LinkedList<>();
        process(list,2,false,false);

    }
}
