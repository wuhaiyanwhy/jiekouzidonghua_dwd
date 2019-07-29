package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserRegister2 extends JszInterfaceTest {

    @Test(description = "绑定手机号")
    public void userRegister2() {
        setUrl("user.register2.uri");
        List<NameValuePair> list = new LinkedList<>();
//        list.add(new BasicNameValuePair("mobile", SqlDetail.getInstance().getParamValue(0,"mobile")));
        process(list,false,false);

    }

}
