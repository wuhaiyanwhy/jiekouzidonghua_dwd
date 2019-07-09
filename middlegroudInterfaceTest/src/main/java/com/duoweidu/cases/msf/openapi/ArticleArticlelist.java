package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleArticlelist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "文章列表")
    public void articleArticlelist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_ARTICLELIST);
        param = "page_num=1&limit=20&zone_id=" + TestSql.getValue("zone_id",4);
        process(true,true);
        generalAssertTest(true);
    }
}
