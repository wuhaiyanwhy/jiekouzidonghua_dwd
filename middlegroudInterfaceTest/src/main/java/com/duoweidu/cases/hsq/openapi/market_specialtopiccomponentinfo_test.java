package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.MarketSpecialtopiccomponentinfoModel;
import org.testng.annotations.Test;

public class market_specialtopiccomponentinfo_test extends HsqInterfaceTest {

    private MarketSpecialtopiccomponentinfoModel model;

    @Test(description = "五福专题页")
    public void market_specialtopiccomponentinfo_true() {
        setUrl("market.specialtopiccomponentinfo.uri");
        param = "topicCode=" + SqlDetail.getInstance().getParamValue("wufuTopicCode");
        process(true,true);
        model = sparseJson(MarketSpecialtopiccomponentinfoModel.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("info.bg_color", model.info.bg_color);
        detailAssertTest("info.foot_text", model.info.foot_text);
        detailAssertTest("info.share_desc", model.info.share_desc);
        detailAssertTest("info.share_img", model.info.share_img);
        detailAssertTest("info.share_title", model.info.share_title);
        detailAssertTest("info.title", model.info.title);
        detailAssertTest("info.left_text.rule_button.url", model.info.rule_button.url);
//        detailAssertTest("info.rule_button.text", model.info.rule_button.text);
        detailAssertTest("info.api_params.componentGroupId", model.info.api_params.componentGroupId);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).comment", model.list.get(i).comment);
//            detailAssertTest("list.get(i).margin_bottom", model.list.get(i).margin_bottom);
//            detailAssertTest("list.get(i).margin_lr", model.list.get(i).margin_lr);
//            detailAssertTest("list.get(i).margin_top", model.list.get(i).margin_top);
//            detailAssertTest("list.get(i).bg_color", model.list.get(i).bg_color);
//            detailAssertTest("list.get(i).width", model.list.get(i).width);
//            detailAssertTest("list.get(i).height", model.list.get(i).height);
            detailAssertTest("list.get(i).list", model.list.get(i).list);
//            for (int j = 0; j < model.list.get(i).list.size(); j++) {
//                detailAssertTest("list.get(i).list.get(j).image.w", model.list.get(i).list.get(j).image.w);
//                detailAssertTest("list.get(i).list.get(j).image.h", model.list.get(i).list.get(j).image.h);
//                detailAssertTest("list.get(i).list.get(j).image.url", model.list.get(i).list.get(j).image.url);
//                detailAssertTest("list.get(i).list.get(j).image.link", model.list.get(i).list.get(j).link);

//            }

        }

    }
}
