package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CommonAuthcode extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发送短信验证码")
    public void commonAuthcode() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.COMMON_AUTHCODE);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("mobile", TestSql.getValue("mobile",4)));
        list.add(new BasicNameValuePair("type","1"));
        list.add(new BasicNameValuePair("platform",TestSql.getValue("platform",4)));

        process(list,false,false);
    }
}
