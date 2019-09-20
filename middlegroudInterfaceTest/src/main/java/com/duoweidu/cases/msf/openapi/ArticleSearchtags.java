package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleSearchtagsData;
import org.testng.annotations.Test;

public class ArticleSearchtags extends MsfInterfaceTest {

    private ArticleSearchtagsData model;

    @Test(description = "标签搜索")
    public void articleSearchtags() {
        setUrl("article.searchtags.uri");
        param = "q=" + SqlDetail.getInstance().getParamValue(0, "tagName");
        process(true,true);
        model = sparseJson(ArticleSearchtagsData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);
            assertNotNull("list.get(i).weight", model.list.get(i).weight);
            assertNotEmpty("list.get(i).is_hot", model.list.get(i).is_hot);
            assertNotEmpty("list.get(i).zone_id", model.list.get(i).zone_id);
        }
        assertNotEmpty("has_next", model.has_next);
    }
}
