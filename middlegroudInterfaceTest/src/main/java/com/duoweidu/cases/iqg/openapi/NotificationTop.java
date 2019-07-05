package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class NotificationTop extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "通知")
    public void notification_top_true() throws IOException {
        setUrl("notification.top.uri");
        process(true,false);
    }
}
