package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleSearchtags extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "标签搜索")
    public void articleSearchtags() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_SEARCHTAGS);
        param = "zone_id=" + TestSql.getValue("zone_id",4) +
                "q=" + TestSql.getValue("tagName",4);
        process(true,true);
    }
}
