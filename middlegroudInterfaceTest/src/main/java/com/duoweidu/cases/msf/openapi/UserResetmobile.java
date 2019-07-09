package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserResetmobile extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "修改手机号")
    public void userResetmobile() {
        setUrl("user.resetmobile.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
