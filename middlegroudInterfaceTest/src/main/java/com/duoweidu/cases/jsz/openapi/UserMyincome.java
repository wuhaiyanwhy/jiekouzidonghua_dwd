package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserMyincome extends JszInterfaceTest {

    @Test(description = "我的收益")
    public void userMyincome() {
        setUrl("user.myincome.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(true, false);
    }
}
