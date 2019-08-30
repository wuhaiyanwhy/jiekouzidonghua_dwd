package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.UserUpdateinfoData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserUpdateinfo extends MsfInterfaceTest {

    private UserUpdateinfoData model;

    @Test(dependsOnGroups = "loginTrue",description = "个人信息修改")
    public void userUpdateinfo() {
        setUrl("user.updateinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("birthday", SqlDetail.getInstance().getParamValue(0, "birthday")));
        process(list,true,false);
        model = sparseJson(UserUpdateinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("result", model.result);
        assertNotEmpty("is_first_complete", model.is_first_complete);
        assertNotEmpty("profile_status.nickname", model.profile_status.nickname);
        assertNotEmpty("profile_status.avatar", model.profile_status.avatar);
        assertNotEmpty("profile_status.gender", model.profile_status.gender);
        assertNotEmpty("profile_status.birthday", model.profile_status.birthday);
        assertNotEmpty("profile_status.introduction", model.profile_status.introduction);

    }
}
