package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.MsfConfig;
import com.duoweidu.model.msf.ArticleCreateData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ArticleCreate extends MsfInterfaceTest {

    private ArticleCreateData model;

    @Test(dependsOnGroups = "loginTrue",description = "发布文章",groups = "createArticle")
    public void articleCreate() {
        setUrl("article.create.uri");
        List<NameValuePair> list = new LinkedList<>();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("title", "标题测试的"));
            list.add(new BasicNameValuePair("content", "美食体验的内容，居然还要13个字真的是，搞定"));
            list.add(new BasicNameValuePair("pic_list", "[{\"height\":399,\"width\":360,\"pic\":\"https:\\/\\/img.mishifeng.com\\/FjsIIq6rvZanTL8YO2k-MtCLIMkB\"}," +
                    "{\"pic\":\"https:\\/\\/img.mishifeng.com\\/FnNanPN6r2QM5ye0-y_l_8gcYZsd\",\"height\":909,\"width\":880}]"));
            list.add(new BasicNameValuePair("stat_id", "2EE6C938-EDE8-4E20-92C0-630A7A1F7066"));
            list.add(new BasicNameValuePair("timestamp", "1562724496"));
            list.add(new BasicNameValuePair("os_version", "12.2"));
            list.add(new BasicNameValuePair("device", "iPhone"));
            list.add(new BasicNameValuePair("star", "50"));
        }
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(ArticleCreateData.class);
            MsfConfig.articleCreateId = String.valueOf(model.id);
            detailAssert();
        }

    }

    private void detailAssert() {
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("title", model.title);
        assertNotEmpty("lng", model.lng);
        assertNotEmpty("lat", model.lat);
        assertNotNull("address", model.address);
        assertNotEmpty("zone_id", model.zone_id);
        assertNotNull("branch_tmp_id", model.branch_tmp_id);
        assertNotNull("branch_id", model.branch_id);
        assertNotEmpty("star", model.star);
        assertNotEmpty("content", model.content);
        assertNotEmpty("status", model.status);
        assertNotNull("video_id", model.video_id);
        assertNotEmpty("pic", model.pic);
        assertNotNull("pic_width", model.pic_width);
        assertNotNull("pic_height", model.pic_height);
        assertNotNull("user_first", model.user_first);
        assertNotNull("order_id", model.order_id);
        assertNotNull("activity_id", model.activity_id);
        assertNotEmpty("id", model.id);

    }
}
