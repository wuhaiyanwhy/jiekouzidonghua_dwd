package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.marketSpecialtopicTopicinfoData;
import org.testng.annotations.Test;

public class MarketSpecialtopicTopicinfo extends HsqInterfaceTest {

    private marketSpecialtopicTopicinfoData model;

    @Test(description = "新专题")
    public void marketSpecialtopicTopicinfo() {
        setUrl("market.specialtopic.topicinfo.uri");
        param = "code=" + SqlDetail.getInstance().getParamValue("newCode");
        process(true, true);
        model = sparseJson(marketSpecialtopicTopicinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).enable", model.list.get(i).enable);
//            detailAssertTest("list.get(i).flow", model.list.get(i).flow);
//            detailAssertTest("list.get(i).margin_top", model.list.get(i).margin_top);
//            detailAssertTest("list.get(i).margin_bottom", model.list.get(i).margin_bottom);
//            detailAssertTest("list.get(i).margin_lr", model.list.get(i).margin_lr);
//            detailAssertTest("list.get(i).width", model.list.get(i).width);
//            detailAssertTest("list.get(i).height", model.list.get(i).height);
//            detailAssertTest("list.get(i).start_time", model.list.get(i).start_time);
//            detailAssertTest("list.get(i).end_time", model.list.get(i).end_time);
            detailAssertTest("list.get(i).comment", model.list.get(i).comment);
            detailAssertTest("list.get(i).list", model.list.get(i).list);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).active", model.list.get(i).active);


//            for (int j = 0; j < model.list.get(i).list.size(); j++) {
//                detailAssertTest("model.list.get(i).list.get(j).image.url", model.list.get(i).list.get(j).image.url);
//                detailAssertTest("model.list.get(i).list.get(j).image.w", model.list.get(i).list.get(j).image.w);
//                detailAssertTest("model.list.get(i).list.get(j).image.h", model.list.get(i).list.get(j).image.h);
//                detailAssertTest("model.list.get(i).list.get(j).link", model.list.get(i).list.get(j).link);

//            }

        }
    }
}
