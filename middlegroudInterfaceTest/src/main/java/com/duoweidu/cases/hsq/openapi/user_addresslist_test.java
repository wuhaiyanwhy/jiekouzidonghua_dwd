package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_addresslist_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取用户地址列表")
    public void user_addresslist_true() {
        setUrl("user.addresslist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);
    }
}
