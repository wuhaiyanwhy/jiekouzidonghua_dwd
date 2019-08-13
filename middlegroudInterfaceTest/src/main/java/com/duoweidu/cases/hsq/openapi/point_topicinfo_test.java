package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.PointTopicinfoData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class point_topicinfo_test extends HsqInterfaceTest {

    private PointTopicinfoData model;

    @Test(description = "获取积分专题信息(老专题)")
    public void point_topicinfo_true() {
        setUrl("point.topicinfo.uri");
        param = "pointChannelId=1&topicCode=" + SqlDetail.getInstance().getParamValue("pointTopicCode");
        process(true, false);
        model = sparseJson(PointTopicinfoData.class);
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

    }
}
