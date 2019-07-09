package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class ArticleFavoritelist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "收藏列表接口")
    public void articleFavoritelist() {
        setUrl("article.favoritelist.uri");
        param = "id=" + SqlDetail.getParamValue("article_id");
        process(true,true);
    }
}
