package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserArticlelistData;
import org.testng.annotations.Test;

public class UserArticlelist extends MsfInterfaceTest {

    private UserArticlelistData model;

    @Test(dependsOnGroups = "loginTrue",description = "美食笔记列表")
    public void userArticlelist() {
        setUrl("user.articlelist.uri");
        param = "page_num=1&page_limit=20";
        process(true,true);
        model = sparseJson(UserArticlelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).title", model.list.get(i).title);
            assertNotEmpty("list.get(i).pic", model.list.get(i).pic);
            assertNotNull("list.get(i).width", model.list.get(i).width);
            assertNotNull("list.get(i).height", model.list.get(i).height);
            assertNotEmpty("list.get(i).media_type", model.list.get(i).media_type);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).user_nickname", model.list.get(i).user_nickname);
            assertNotEmpty("list.get(i).user_avatar", model.list.get(i).user_avatar);
            assertNotNull("list.get(i).quality_user", model.list.get(i).quality_user);
            assertNotNull("list.get(i).likes_num", model.list.get(i).likes_num);
            assertNotEmpty("list.get(i).likes_status", model.list.get(i).likes_status);
        }
    }
}

