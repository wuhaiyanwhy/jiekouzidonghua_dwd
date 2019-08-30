package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleFavoritelistData;
import org.testng.annotations.Test;

public class ArticleFavoritelist extends MsfInterfaceTest {

    private ArticleFavoritelistData model;

    @Test(dependsOnGroups = "loginTrue",description = "收藏列表接口")
    public void articleFavoritelist() {
        setUrl("article.favoritelist.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,true);
        model = sparseJson(ArticleFavoritelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).article_id", model.list.get(i).article_id);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotNull("list.get(i).status", model.list.get(i).status);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
            assertNotEmpty("list.get(i).nickname", model.list.get(i).nickname);
            assertNotEmpty("list.get(i).avatar", model.list.get(i).avatar);
            assertNotNull("list.get(i).quality_user", model.list.get(i).quality_user);
        }
    }
}
