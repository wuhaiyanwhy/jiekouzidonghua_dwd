package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ProductTopicskusinfoData;
import org.testng.annotations.Test;

public class product_topicskusinfo_test extends HsqInterfaceTest {

    private ProductTopicskusinfoData model;

    @Test(description = "获取专题sku信息")
    public void product_topicskusinfo_true() {
        setUrl("product.topicskusinfo.uri");
        param = "topicCode=" + SqlDetail.getInstance().getParamValue("topicCode");
        process(true,false);
        model = sparseJson(ProductTopicskusinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("code", model.code);
        detailAssertTest("title", model.title);
        detailAssertTest("is_rtf", model.is_rtf);
        detailAssertTest("status", model.status);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest("source_type", model.source_type);
        detailAssertTest("last_update", model.last_update);
        detailAssertTest("type", model.type);
        detailAssertTest("topic_type", model.topic_type);
        detailAssertTest("topic_sub_type", model.topic_sub_type);
//        detailAssertTest("detail", model.detail);
        detailAssertTest("model.shareInfo.firendsZone.thumbnail", model.shareInfo.firendsZone.thumbnail);
        detailAssertTest("model.shareInfo.firendsZone.link", model.shareInfo.firendsZone.link);
        detailAssertTest("model.shareInfo.firendsZone.content", model.shareInfo.firendsZone.content);
        detailAssertTest("shareInfo.wechat.isMini", model.shareInfo.wechat.isMini);
        detailAssertTest("shareInfo.wechat.pagePath", model.shareInfo.wechat.pagePath);
        detailAssertTest("shareInfo.wechat.userName", model.shareInfo.wechat.userName);
        detailAssertTest("shareInfo.wechat.title", model.shareInfo.wechat.title);
        detailAssertTest("model.shareInfo.wechat.thumbnail", model.shareInfo.wechat.thumbnail);
        detailAssertTest("model.shareInfo.wechat.link", model.shareInfo.wechat.link);
        detailAssertTest("model.shareInfo.wechat.content", model.shareInfo.wechat.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);
        detailAssertTest("model.shareInfo.mobileQQ.thumbnail", model.shareInfo.mobileQQ.thumbnail);
        detailAssertTest("model.shareInfo.mobileQQ.link", model.shareInfo.mobileQQ.link);
        detailAssertTest("model.shareInfo.mobileQQ.content", model.shareInfo.mobileQQ.content);
        detailAssertTest("shareInfo.mobileQQ.title", model.shareInfo.mobileQQ.title);


    }
}
