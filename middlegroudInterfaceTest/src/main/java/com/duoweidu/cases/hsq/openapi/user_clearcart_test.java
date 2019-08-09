package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_clearcart_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "loginTrue",description = "清空购物车")
    public void user_clearcart_true() {
        setUrl("user.clearcart.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
