package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserGethoneyData;
import org.testng.annotations.Test;

public class UserGethoney extends MsfInterfaceTest {

    private UserGethoneyData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜信息")
    public void userGethoney() {
        setUrl("user.gethoney.uri");
        process(true,false);
        model = sparseJson(UserGethoneyData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("honey", model.honey);
        assertNotEmpty("money", model.money);

    }

}
