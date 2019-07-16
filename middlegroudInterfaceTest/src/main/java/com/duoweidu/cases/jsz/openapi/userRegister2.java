package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.InterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class userRegister2 extends InterfaceTest {

    @Test(groups = "loginTure",description = "登陆")
    public void userRegister2() {
        setUrl("user.register2.uri");
        List<NameValuePair> list = new LinkedList<>();
//        list.add(new BasicNameValuePair("mobile", SqlDetail.getInstance().getParamValue(0, "mobile")));
//        list.add(new BasicNameValuePair("verify_code", SqlDetail.getInstance().getParamValue(0, "verify_code")));
        process(list,false,false);

    }

}
