package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleTogglefavorite extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "切换收藏的接口")
    public void articleTogglefavorite() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_TOGGLEFAVORITE);
        param = "id=" + TestSql.getValue("article_id");
        process(true,false);
    }
}
