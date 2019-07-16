package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleCommentuserlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取当前文章评论用户接口")
    public void articleCommentuserlist() {
        setUrl("article.commentuserlist.uri");
        param = "article_id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,true);
    }
}
