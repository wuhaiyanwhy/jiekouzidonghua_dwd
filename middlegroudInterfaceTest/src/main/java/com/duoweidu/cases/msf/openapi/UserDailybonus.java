package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserDailybonus extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "签到领积分")
    public void userDailybonus() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_DAILYBONUS);
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
