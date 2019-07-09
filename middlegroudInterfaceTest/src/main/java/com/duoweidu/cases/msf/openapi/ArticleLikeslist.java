package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleLikeslist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "点赞列表")
    public void articleLikeslist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_LIKESLIST);
        param = "id=" + TestSql.getValue("article_id");
        process(true,true);
    }
}
