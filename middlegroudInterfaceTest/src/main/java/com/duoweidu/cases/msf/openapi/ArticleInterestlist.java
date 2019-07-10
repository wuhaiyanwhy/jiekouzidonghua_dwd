package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class ArticleInterestlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "详情页推荐文章列表接口（你可能感兴趣）")
    public void articleInterestlist() {
        setUrl("article.interestlist.uri");
        param = "id=" + SqlDetail.getParamValue("article_id");
        process(true,false);
    }
}
