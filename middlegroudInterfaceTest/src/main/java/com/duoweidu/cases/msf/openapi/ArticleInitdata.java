package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ArticleInitdataData;
import org.testng.annotations.Test;

public class ArticleInitdata extends MsfInterfaceTest {

    private ArticleInitdataData model;

    @Test(dependsOnGroups = "loginTrue",description = "发布页初始化")
    public void articleInitdata() {
        setUrl("article.initdata.uri");
        param = "order_id=" + SqlDetail.getInstance().getParamValue("order_id");
        process(true,false);
        model = sparseJson(ArticleInitdataData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("branch.id", model.branch.id);
        assertNotEmpty("branch.branch_name", model.branch.branch_name);
        assertNotEmpty("branch.lng", model.branch.lng);
        assertNotEmpty("branch.lat", model.branch.lat);
        assertNotEmpty("branch.address", model.branch.address);
        assertNotEmpty("branch.zone_id", model.branch.zone_id);
        assertNotEmpty("branch.status", model.branch.status);
        assertNotEmpty("branch.created_at", model.branch.created_at);
        assertNotEmpty("order_id", model.order_id);
        assertNotEmpty("branch.words.min", model.words.min);
        assertNotEmpty("branch.words.middle", model.words.middle);
        assertNotEmpty("branch.words.max", model.words.max);
        assertNotEmpty("branch.words.publish_honey", model.words.publish_honey);
        assertNotEmpty("branch.words.recommend_honey", model.words.recommend_honey);
        assertNotEmpty("article.order_id", model.article.order_id);
        assertNotEmpty("article.activity_id", model.article.activity_id);
    }
}
