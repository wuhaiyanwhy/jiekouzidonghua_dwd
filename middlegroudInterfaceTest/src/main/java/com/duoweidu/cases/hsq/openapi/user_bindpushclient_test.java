package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.UserBindpushclientData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_bindpushclient_test extends HsqInterfaceTest {

    private UserBindpushclientData model;

    @Test(dependsOnGroups = "loginTrue",description = "绑定用户推送设备")
    public void user_bindpushclient_true() {
        setUrl("user.bindpushclient.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("clientId","f749891bf525cf13cc79d5f8efb63fa9"));
        process(list,true,false);
        model = sparseJson(UserBindpushclientData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("clientId", model.clientId);
        detailAssertTest("alias", model.alias);
        detailAssertTest("tags", model.tags);

    }
}
