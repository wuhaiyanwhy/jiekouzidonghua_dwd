package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.UserGetredbaginfoData;
import org.testng.annotations.Test;

public class UserGetredbaginfo extends FybInterfaceTest {

    private UserGetredbaginfoData model;

    @Test(description = "获取用户未激活红包余额")
    public void userGetredbaginfo() {
        setUrl("user.getredbaginfo.uri");
        process(true,false);
        model = sparseJson(UserGetredbaginfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotNull("isShowRedBag", model.isShowRedBag);
        assertNotNull("redBagMoney", model.redBagMoney);
    }
}
