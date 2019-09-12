package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleLikeslistData;
import org.testng.annotations.Test;

public class ArticleLikeslist extends MsfInterfaceTest {

    private ArticleLikeslistData model;

    @Test(dependsOnGroups = "loginTrue",description = "点赞列表")
    public void articleLikeslist() {
        setUrl("article.likeslist.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,true);
        model = sparseJson(ArticleLikeslistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).article_id", model.list.get(i).article_id);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).status", model.list.get(i).status);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
            assertNotEmpty("list.get(i).nickname", model.list.get(i).nickname);
            assertNotEmpty("list.get(i).avatar", model.list.get(i).avatar);
            assertNotNull("list.get(i).quality_user", model.list.get(i).quality_user);
        }
    }
}
