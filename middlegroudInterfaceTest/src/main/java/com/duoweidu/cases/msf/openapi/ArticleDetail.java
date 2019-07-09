package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleDetail extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "文章详情")
    public void articleDetail() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_DETAIL);
        param = "id=" + TestSql.getValue("article_id");
        process(true,false);

    }
}
