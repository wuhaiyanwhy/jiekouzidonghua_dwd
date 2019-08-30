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
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("nickname", model.nickname);
        assertNotEmpty("avatar", model.avatar);
        assertNotNull("quality_user", model.quality_user);
        assertNotNull("introduction", model.introduction);
        assertNotEmpty("keep_sign_days", model.keep_sign_days);
        assertNotEmpty("fans_num", model.fans_num);
        assertNotEmpty("follow_num", model.follow_num);
        assertNotEmpty("likes_num", model.likes_num);
        assertNotEmpty("favorite_num", model.favorite_num);
        assertNotEmpty("total_honey", model.total_honey);
        assertNotEmpty("has_daily_bonus", model.has_daily_bonus);
        assertNotEmpty("is_followed", model.is_followed);
        assertNotEmpty("about_daily_bonus", model.about_daily_bonus);
        for (int i = 0; i < model.article.list.size(); i++) {
            assertNotEmpty("article.list.get(i).id", model.article.list.get(i).id);
            assertNotEmpty("article.list.get(i).title", model.article.list.get(i).title);
            assertNotEmpty("article.list.get(i).pic", model.article.list.get(i).pic);
            assertNotNull("article.list.get(i).width", model.article.list.get(i).width);
            assertNotNull("article.list.get(i).height", model.article.list.get(i).height);
            assertNotEmpty("article.list.get(i).media_type", model.article.list.get(i).media_type);
            assertNotEmpty("article.list.get(i).user_id", model.article.list.get(i).user_id);
            assertNotEmpty("article.list.get(i).user_nickname", model.article.list.get(i).user_nickname);
            assertNotEmpty("article.list.get(i).user_avatar", model.article.list.get(i).user_avatar);
            assertNotNull("article.list.get(i).quality_user", model.article.list.get(i).quality_user);
            assertNotNull("article.list.get(i).likes_num", model.article.list.get(i).likes_num);
            assertNotEmpty("article.list.get(i).likes_status", model.article.list.get(i).likes_status);
        }
        assertNotEmpty("article.total_page", model.article.total_page);
        assertNotEmpty("article.total_cnt", model.article.total_cnt);
        assertNotEmpty("article.page_limit", model.article.page_limit);
        assertNotEmpty("article_tab_num.favorite_num", model.article_tab_num.favorite_num);
        assertNotEmpty("article_tab_num.article_num", model.article_tab_num.article_num);
    }
}
