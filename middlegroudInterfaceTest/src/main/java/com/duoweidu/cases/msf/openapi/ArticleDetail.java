package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleDetail extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "文章详情")
    public void articleDetail() {
        setUrl("article.detail.uri");
        param = "id=" + SqlDetail.getParamValue("article_id");
        process(true,false);

    }
}
