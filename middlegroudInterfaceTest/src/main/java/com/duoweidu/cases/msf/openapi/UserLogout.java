package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.ResultData;
import org.apache.http.NameValuePair;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserLogout extends MsfInterfaceTest {

    private ResultData model;

    @AfterClass
    @Test(description = "退出登录")
    public void userLogout() {
        setUrl("user.logout.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(ResultData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertEquals("result", model.result, "success");
    }
}

