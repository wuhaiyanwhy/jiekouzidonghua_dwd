package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.testng.annotations.Test;

public class ArticleCommentlist extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评论列表接口")
    public void articleCommentlist() {
        setUrl("article.commentlist.uri");
        param = "id=" + SqlDetail.getParamValue(0, "article_id");
        process(true,false);
    }
}
