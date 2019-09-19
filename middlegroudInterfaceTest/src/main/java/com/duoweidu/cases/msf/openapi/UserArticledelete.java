package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.model.msf.ResultData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserArticledelete extends MsfInterfaceTest {

    private ResultData model;

    @Test(dependsOnGroups = "commentArticle",description = "删除文章")
    public void userArticledelete() {
        setUrl("user.articledelete.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("article_id", MsfConfig.articleCreateId));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ResultData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        assertEquals("result", model.result, "success");
    }
}
