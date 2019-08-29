package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserFollowlistData;
import org.testng.annotations.Test;

public class UserFollowlist extends MsfInterfaceTest {

    private UserFollowlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "关注/粉丝列表")
    public void userFollowlist() {
        setUrl("user.followlist.uri");
        param = "type=1";
        process(true,true);
        model = sparseJson(UserFollowlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).user_type", model.list.get(i).user_type);
            assertNotEmpty("list.get(i).nickname", model.list.get(i).nickname);
            assertNotEmpty("list.get(i).avatar", model.list.get(i).avatar);
            assertNotEmpty("list.get(i).introduction", model.list.get(i).introduction);
            assertNotNull("list.get(i).article_num", model.list.get(i).article_num);
            assertNotNull("list.get(i).fans_num", model.list.get(i).fans_num);
            assertNotEmpty("list.get(i).followed", model.list.get(i).followed);
            assertNotNull("list.get(i).quality_user", model.list.get(i).quality_user);
        }
    }

}
