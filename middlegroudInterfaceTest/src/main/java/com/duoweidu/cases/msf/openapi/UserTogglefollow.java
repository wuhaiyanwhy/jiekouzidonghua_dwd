package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.UserTogglefollowData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserTogglefollow extends MsfInterfaceTest {

    private UserTogglefollowData model;

    @Test(dependsOnGroups = "loginTrue",description = "关注/取消关注")
    public void userTogglefollow() {
        setUrl("user.togglefollow.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("follow_user_id", SqlDetail.getInstance().getParamValue("follow_user_id")));
        process(list,true,false);
        model = sparseJson(UserTogglefollowData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("result", model.result);
    }

}
