package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleCommentlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评论列表接口")
    public void articleCommentlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_COMMENTLIST);
        param = "id=" + TestSql.getValue("article_id", 4);
        process(true,false);
    }
}
