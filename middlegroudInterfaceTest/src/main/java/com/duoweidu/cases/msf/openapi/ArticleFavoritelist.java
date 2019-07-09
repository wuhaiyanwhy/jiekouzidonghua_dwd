package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleFavoritelist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "收藏列表接口")
    public void articleFavoritelist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_FAVORITELIST);
        param = "id=" + TestSql.getValue("article_id");
        process(true,true);
    }
}
