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

public class UserUpdateinfo extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人信息修改")
    public void userUpdateinfo() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_UPDATEINFO);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("birthday", TestSql.getValue("birthday",4)));
        process(list,true,false);
    }
}
