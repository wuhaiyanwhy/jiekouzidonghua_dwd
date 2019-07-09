package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserSetting extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "账户设置")
    public void userSetting() {
        setUrl("user.setting.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
