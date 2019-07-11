package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_clearcart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "清空购物车")
    public void user_clearcart_true() {
        setUrl("user.clearcart.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }

}
