package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.HomeIndexData;
import org.testng.annotations.Test;

public class HomeIndex extends MsfInterfaceTest {

    private HomeIndexData model;

    @Test(description = "首页")
    public void homeIndex() {
        setUrl("home.index.uri");
        process(true,false);
        model = sparseJson(HomeIndexData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotNull("ads.width", model.ads.width);
        assertNotNull("ads.height", model.ads.height);
        assertNotEmpty("ads.list", model.ads.list);
        for (int i = 0; i < model.ads.list.size(); i++) {
            assertNotEmpty("ads.list.get(i).id", model.ads.list.get(i).id);
            assertNotNull("ads.list.get(i).width", model.ads.list.get(i).width);
            assertNotNull("ads.list.get(i).height", model.ads.list.get(i).height);
            assertNotEmpty("ads.list.get(i).link", model.ads.list.get(i).link);
        }
        assertNotEmpty("tags", model.tags);

        for (int i = 0; i < model.tags.size(); i++) {
            assertNotNull("tags.get(i).id", model.tags.get(i).id);
        }
        assertNotEmpty("categories", model.categories);
        for (int i = 0; i < model.categories.size(); i++) {
            assertNotEmpty("categories.get(i).id", model.categories.get(i).id);
            assertNotEmpty("categories.get(i).name", model.categories.get(i).name);
        }
        assertNotEmpty("article.total_cnt", model.article.total_cnt);
        assertNotEmpty("article.total_page", model.article.total_page);
        assertNotEmpty("article.list", model.article.list);
        for (int i = 0; i < model.article.list.size(); i++) {
            assertNotEmpty("article.list.get(i).id", model.article.list.get(i).id);
            assertNotEmpty("article.list.get(i).title", model.article.list.get(i).title);
            assertNotEmpty("article.list.get(i).pic", model.article.list.get(i).pic);
            assertNotEmpty("article.list.get(i).width", model.article.list.get(i).width);
            assertNotEmpty("article.list.get(i).height", model.article.list.get(i).height);
            assertNotEmpty("article.list.get(i).media_type", model.article.list.get(i).media_type);
            assertNotEmpty("article.list.get(i).user_id", model.article.list.get(i).user_id);
            assertNotEmpty("article.list.get(i).user_nickname", model.article.list.get(i).user_nickname);
            assertNotEmpty("article.list.get(i).user_avatar", model.article.list.get(i).user_avatar);
            assertNotNull("article.list.get(i).quality_user", model.article.list.get(i).quality_user);
            assertNotEmpty("article.list.get(i).likes_num", model.article.list.get(i).likes_num);
            assertNotEmpty("article.list.get(i).likes_status", model.article.list.get(i).likes_status);
        }
        assertNotEmpty("article.page_serial", model.article.page_serial);

    }

}
