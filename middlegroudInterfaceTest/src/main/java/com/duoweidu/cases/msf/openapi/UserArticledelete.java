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

public class UserArticledelete extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "commentArticle",description = "删除文章")
    public void userArticledelete() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.USER_ARTICLEDELETE);
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            list.add(new BasicNameValuePair("article_id", TestConfigOpenapi.articleCreateId));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
        }
    }
}
