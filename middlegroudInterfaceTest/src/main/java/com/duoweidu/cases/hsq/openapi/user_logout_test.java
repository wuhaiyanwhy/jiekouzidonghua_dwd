package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_logout_test extends HsqInterfaceTest {

    private ResData model;

    @AfterClass
    @Test(description = "用户登出")
    public void user_logout_true() {
        setUrl("user.logout.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
