package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CommonAuthcode extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发送短信验证码")
    public void commonAuthcode() {
        setUrl("common.authcode.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", SqlDetail.getParamValue(0, "mobile")));
        list.add(new BasicNameValuePair("type","1"));
        process(list,false,false);
    }
}
