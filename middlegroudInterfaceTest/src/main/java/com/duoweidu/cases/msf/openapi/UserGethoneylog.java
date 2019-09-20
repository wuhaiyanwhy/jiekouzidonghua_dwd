package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserGethoneylogData;
import org.testng.annotations.Test;

public class UserGethoneylog extends MsfInterfaceTest {

    private UserGethoneylogData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取用户蜂蜜日志")
    public void userGethoneylog() {
        setUrl("user.gethoneylog.uri");
        param = "page_num=1&page_limit=20";
        process(true,true);
        model = sparseJson(UserGethoneylogData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).type", model.list.get(i).type);
            assertNotEmpty("list.get(i).honey", model.list.get(i).honey);
            assertNotEmpty("list.get(i).remark", model.list.get(i).remark);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).title", model.list.get(i).title);

        }
    }
}
