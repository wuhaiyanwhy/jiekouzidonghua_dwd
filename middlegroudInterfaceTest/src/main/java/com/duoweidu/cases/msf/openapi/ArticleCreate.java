package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfacetest.OpenapiInterfaceTest;
import com.duoweidu.config.TestConfigOpenapi;
import com.duoweidu.config.TestSql;
import com.duoweidu.utils.ConfigFileOpenapi;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ArticleCreate extends OpenapiInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "发布文章",groups = "createArticle")
    public void articleCreate() throws IOException {
        url = ConfigFileOpenapi.getUrlByKey(ConfigFileOpenapi.ARTICLE_CREATE);
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            list.add(new BasicNameValuePair("title", "测试发布文章"));
            list.add(new BasicNameValuePair("content", "测试发布文章的内容"));
            list.add(new BasicNameValuePair("pic_list", "[{\"height\":332,\"width\":444,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FoJXoe7FsVJGES7crHYy-ZwPWYei\"}," +
                    "{\"height\":683,\"width\":912,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FlqiYc2og41Ry1MHBe2BAQGrBGpG\"}," +
                    "{\"height\":659,\"width\":663,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FsqY2uGOSeUDSvMA5PHw6AYnxUZy\"}]"));
            list.add(new BasicNameValuePair("lat", TestSql.getValue("lat",4)));
            list.add(new BasicNameValuePair("lng", TestSql.getValue("lng",4)));
            list.add(new BasicNameValuePair("zone_id", TestSql.getValue("zone_id",4)));
            list.add(new BasicNameValuePair("star", "50"));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileOpenapi.getEnv())) {
            generalAssertTest(false);
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            TestConfigOpenapi.articleCreateId = data.get("id").toString();
        }

    }
}
