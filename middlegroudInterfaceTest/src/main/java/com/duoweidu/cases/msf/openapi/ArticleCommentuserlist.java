package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleCommentuserlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取当前文章评论用户接口")
    public void articleCommentuserlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_COMMENTUSERLIST);
        param = "article_id=" + TestSql.getValue("article_id");
        process(true,true);
    }
}
