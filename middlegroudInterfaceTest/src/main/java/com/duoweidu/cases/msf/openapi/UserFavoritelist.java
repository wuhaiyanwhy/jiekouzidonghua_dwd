package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.UserFavoritelistData;
import org.testng.annotations.Test;

public class UserFavoritelist extends MsfInterfaceTest {

    private UserFavoritelistData model;

    @Test(dependsOnGroups = "loginTrue",description = "用户收藏列表")
    public void userFavoritelist() {
        setUrl("user.favoritelist.uri");
        param = "page_num=1&page_limit=20&need_pagination=1";
        process(true,true);
        model = sparseJson(UserFavoritelistData.class);
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
            assertNotEmpty("list.get(i).likes_num", model.list.get(i).likes_num);
            assertNotEmpty("list.get(i).likes_status", model.list.get(i).likes_status);
        }
        assertNotEmpty("total_page", model.total_page);
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("page_limit", model.page_limit);

    }
}
