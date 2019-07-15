package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_mtceventnotify_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息推送管理")
    public void market_mtceventnotify_show_true() {

        setUrl("market.mtceventnotify.show.uri");
        process(false,false);

    }
}
