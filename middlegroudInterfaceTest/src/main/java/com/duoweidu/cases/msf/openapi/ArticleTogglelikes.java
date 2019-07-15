package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleTogglelikes extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "点赞与取消点赞")
    public void articleTogglelikes() {
        setUrl("article.togglelikes.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,false);
    }
}
