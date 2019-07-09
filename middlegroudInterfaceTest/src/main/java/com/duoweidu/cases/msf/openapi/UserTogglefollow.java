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

public class UserTogglefollow extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "关注/取消关注")
    public void userTogglefollow() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_TOGGLEFOLLOW);

        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("follow_user_id", TestSql.getValue("follow_user_id")));
        process(list,true,false);
    }

}
