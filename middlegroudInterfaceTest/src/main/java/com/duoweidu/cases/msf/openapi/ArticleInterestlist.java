package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleInterestlist extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "详情页推荐文章列表接口（你可能感兴趣）")
    public void articleInterestlist() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_INTERESTLIST);
        param = "zone_id=" + TestSql.getValue("zone_id",4)
                + "&id=" + TestSql.getValue("article_id");
        process(true,false);
    }
}
