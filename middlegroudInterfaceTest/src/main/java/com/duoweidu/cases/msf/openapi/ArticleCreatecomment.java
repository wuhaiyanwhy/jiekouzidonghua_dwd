package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.utils.TraverseResult;
import com.duoweidu.model.msf.ArticleCreatecommentData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArticleCreatecomment extends MsfInterfaceTest {

    private ArticleCreatecommentData model;

    @Test(dependsOnGroups = "createArticle",description = "提交评论接口",groups = "commentArticle")
    public void articleCreatecomment() {
        setUrl("article.createcomment.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("id", MsfConfig.articleCreateId));
        }
        list.add(new BasicNameValuePair("content","很好哦"));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ArticleCreatecommentData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseResult.traverseObj(model);
        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }
    }
}
