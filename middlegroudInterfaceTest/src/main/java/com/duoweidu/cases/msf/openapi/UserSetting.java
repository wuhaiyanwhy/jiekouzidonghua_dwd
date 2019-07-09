package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserSetting extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "账户设置")
    public void userSetting() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_SETTING);
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
