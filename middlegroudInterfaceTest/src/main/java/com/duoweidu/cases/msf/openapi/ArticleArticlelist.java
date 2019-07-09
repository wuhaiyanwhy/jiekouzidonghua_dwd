package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import org.testng.annotations.Test;

public class ArticleArticlelist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "文章列表")
    public void articleArticlelist() {
        setUrl("article.articlelist.uri");
        param = "page_num=1&limit=20";
        process(true,true);
        generalAssertTest(true);
    }
}
