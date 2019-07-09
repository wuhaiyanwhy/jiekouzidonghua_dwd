package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.testng.annotations.Test;

import java.io.IOException;

public class ArticleInitdata extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发布页初始化")
    public void articleInitdata() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_INITDATA);
        param = "order_id=" + TestSql.getValue("order_id");
        process(true,false);
    }
}
