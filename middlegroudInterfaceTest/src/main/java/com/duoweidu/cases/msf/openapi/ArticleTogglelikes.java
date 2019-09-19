package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleTogglelikesData;
import org.testng.annotations.Test;

public class ArticleTogglelikes extends MsfInterfaceTest {
    
    private ArticleTogglelikesData model;

    @Test(dependsOnGroups = "loginTrue",description = "点赞与取消点赞")
    public void articleTogglelikes() {
        setUrl("article.togglelikes.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,false);
        model = sparseJson(ArticleTogglelikesData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("status", model.status);
        assertNotEmpty("id", model.id);
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("article_id", model.article_id);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("updated_at", model.updated_at);
        assertNotEmpty("likes_num", model.likes_num);

    }
}
