package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.UserRefreshloginData;
import org.testng.annotations.Test;

public class UserRefreshlogin extends JszInterfaceTest {

    private UserRefreshloginData model;

    @Test(description = "获取token")
    public void userRefreshlogin (){
        setUrl("user.refreshlogin.uri");
        process(true,false);
        model = sparseJson(UserRefreshloginData.class);

        detailAssert();
        //更新token
        SqlDetail.getInstance().updatePathValue("token", model.token);
    }

    private void detailAssert() {
        assertNotEmpty("token", model.token);
    }
}
