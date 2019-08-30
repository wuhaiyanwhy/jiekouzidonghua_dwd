package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserProfileData;
import org.testng.annotations.Test;

public class UserProfile extends MsfInterfaceTest {

    private UserProfileData model;

    @Test(dependsOnGroups = "loginTrue",description = "个人中心详情页")
    public void userProfile() {
        setUrl("user.profile.uri");
        param = "page_num=1&page_limit=20";
        process(true,false);
        model = sparseJson(UserProfileData.class);
        detailAssert();
    }

    private void detailAssert() {


    }
}
