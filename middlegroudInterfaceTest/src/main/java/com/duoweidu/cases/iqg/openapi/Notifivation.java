package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Notifivation extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "通知中心")
    public void notifivationTrue() {
        setUrl("notification.uri");
        process(false,false);
    }

}
