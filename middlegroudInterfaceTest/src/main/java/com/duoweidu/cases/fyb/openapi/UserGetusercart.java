package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.model.fyb.UserGetusercartData;
import org.testng.annotations.Test;

import java.util.Map;

public class UserGetusercart extends FybInterfaceTest {

    private UserGetusercartData model;

    @Test(dependsOnGroups = "userAddskutocart",description = "获取用户购物车",groups = "userGetusercart")
    public void userGetusercart() {
        setUrl("user.getusercart.uri");
        process(true,true);
        model = sparseJson(UserGetusercartData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseConfig.traverseObj(model);
        Map<String, Object> mapList = TraverseConfig.traverseCollection(model.list);
        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

    }
}
