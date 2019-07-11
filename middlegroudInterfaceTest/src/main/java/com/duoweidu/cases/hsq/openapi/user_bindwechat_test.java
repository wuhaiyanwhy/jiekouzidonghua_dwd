package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_bindwechat_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "绑定微信")
    public void user_bindwechat_true() {
        setUrl("user.bindwechat.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code","001Ma0wm0TUIns1S5jvm0sE8wm0Ma0wr"));
        process(list,false,false);
    }
}
