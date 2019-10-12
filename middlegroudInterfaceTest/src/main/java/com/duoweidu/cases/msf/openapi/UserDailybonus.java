package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 只能领一次，暂时无需详细断言
 */
public class UserDailybonus extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "签到领积分")
    public void userDailybonus() {
        setUrl("user.dailybonus.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
