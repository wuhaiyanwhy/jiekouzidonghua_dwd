package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class market_mtcnotifytpl_show_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "消息模板管理")
    public void market_mtcnotifytpl_show_true() {

        setUrl("market.mtcnotifytpl.show.uri");
        process(false,false);

    }
}
