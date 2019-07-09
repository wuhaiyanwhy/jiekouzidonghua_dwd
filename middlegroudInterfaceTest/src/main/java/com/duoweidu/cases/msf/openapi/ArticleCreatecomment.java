package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ArticleCreatecomment extends OpenapiInterfaceTest{

    @Test(dependsOnGroups = "createArticle",description = "提交评论接口",groups = "commentArticle")
    public void articleCreatecomment() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_CREATECOMMENT);
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            list.add(new BasicNameValuePair("id", TestConfigOpenapi.articleCreateId));
        }
        list.add(new BasicNameValuePair("content","很好哦"));
        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
        }
    }
}
