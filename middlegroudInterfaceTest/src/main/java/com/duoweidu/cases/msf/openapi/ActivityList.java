package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;


public class ActivityList extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "活动列表")
    public void ActivityList() {
        setUrl("activity.list.uri");
        process(true,true);
    }
}
