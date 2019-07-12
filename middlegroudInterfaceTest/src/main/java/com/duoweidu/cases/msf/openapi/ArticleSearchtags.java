package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class ArticleSearchtags extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "标签搜索")
    public void articleSearchtags() {
        setUrl("article.searchtags.uri");
        param = "q=" + SqlDetail.getParamValue(0, "tagName");
        process(true,true);
    }
}
