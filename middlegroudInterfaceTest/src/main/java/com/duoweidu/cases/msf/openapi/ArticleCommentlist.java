package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

/**
 * 暂无评论，暂时无需详细断言
 */
public class ArticleCommentlist extends MsfInterfaceTest {

    @Test(description = "评论列表接口")
    public void articleCommentlist() {
        setUrl("article.commentlist.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("article_id");
        process(true,false);
    }
}
