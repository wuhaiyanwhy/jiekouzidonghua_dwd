package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleTogglelikes extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "点赞与取消点赞")
    public void articleTogglelikes() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_TOGGLELIKES);
        param = "id=" + TestSql.getValue("article_id");
        process(true,false);
    }
}
