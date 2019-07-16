package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_updateuser_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void user_updateuser_true() {
        setUrl("user.updateuser.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("birthday","2018-9-5"));
        process(list,true,false);
    }

}
