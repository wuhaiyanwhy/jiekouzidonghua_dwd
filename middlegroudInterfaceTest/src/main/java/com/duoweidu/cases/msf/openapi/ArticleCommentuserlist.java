package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleCommentuserlistData;
import org.testng.annotations.Test;

public class ArticleCommentuserlist extends MsfInterfaceTest {

    private ArticleCommentuserlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取当前文章评论用户接口")
    public void articleCommentuserlist() {
        setUrl("article.commentuserlist.uri");
        param = "article_id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,true);
        model = sparseJson(ArticleCommentuserlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotNull("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).avatar", model.list.get(i).avatar);
            assertNotEmpty("list.get(i).nickname", model.list.get(i).nickname);
        }
        assertNotEmpty("last_id", model.last_id);
        assertNotEmpty("has_next", model.has_next);
    }
}
