package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ArticleCreate extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发布文章",groups = "createArticle")
    public void articleCreate() {
        setUrl("article.create.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("title", "测试发布文章"));
            list.add(new BasicNameValuePair("content", "测试发布文章的内容"));
            list.add(new BasicNameValuePair("pic_list", "[{\"height\":332,\"width\":444,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FoJXoe7FsVJGES7crHYy-ZwPWYei\"}," +
                    "{\"height\":683,\"width\":912,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FlqiYc2og41Ry1MHBe2BAQGrBGpG\"}," +
                    "{\"height\":659,\"width\":663,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FsqY2uGOSeUDSvMA5PHw6AYnxUZy\"}]"));
            list.add(new BasicNameValuePair("star", "50"));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            MsfConfig.articleCreateId = data.get("id").toString();
        }

    }
}
