package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class ActivityAssistancecomplainttype extends HsqInterfaceTest {

    @Test(description = "获取助力免单客诉类型")
    public void activityAssistancecomplainttype() {
        setUrl("activity.assistancecomplainttype.uri");
        process(true, false);
    }
}
