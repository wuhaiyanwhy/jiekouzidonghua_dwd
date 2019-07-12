package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleTogglefavorite extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "切换收藏的接口")
    public void articleTogglefavorite() {
        setUrl("article.togglefavorite.uri");
        param = "id=" + SqlDetail.getParamValue("article_id");
        process(true,false);
    }
}
