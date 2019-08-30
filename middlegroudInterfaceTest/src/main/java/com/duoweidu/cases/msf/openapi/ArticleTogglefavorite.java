package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleTogglefavoriteData;
import com.duoweidu.utils.TraverseResult;
import org.testng.annotations.Test;

import java.util.Map;

public class ArticleTogglefavorite extends MsfInterfaceTest {
    
    private ArticleTogglefavoriteData model;

    @Test(dependsOnGroups = "loginTrue",description = "切换收藏的接口")
    public void articleTogglefavorite() {
        setUrl("article.togglefavorite.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,false);
        model = sparseJson(ArticleTogglefavoriteData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("status", model.status);
        assertNotEmpty("id", model.id);
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("article_id", model.article_id);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("updated_at", model.updated_at);
        assertNotEmpty("favorite_num", model.favorite_num);
    }
}
