package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonIndexV2Data;
import org.testng.annotations.Test;

public class CommonIndexV2 extends HsqInterfaceTest {

    private CommonIndexV2Data model;

    @Test(description = "新首页接口")
    public void commonIndexV2() {
        setUrl("common.index_v2.uri");
        param = "type=1";
        process(true,false);
        model = sparseJson(CommonIndexV2Data.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("channel", model.channel);
        detailAssertTest("title", model.title);
        detailAssertTest("status", model.status);
        detailAssertTest("start_time", model.start_time);
        detailAssertTest("end_time", model.end_time);
        detailAssertTest("delete_flag", String.valueOf(model.delete_flag));
        detailAssertTest("type", String.valueOf(model.type));
        detailAssertTest("sub_type", String.valueOf(model.sub_type));
//        detailAssertTest("code", model.code);
        detailAssertTest("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).enable", model.list.get(i).enable);
//            detailAssertTest("list.get(i).flow", model.list.get(i).flow);
            detailAssertTest("list.get(i).margin_top", String.valueOf(model.list.get(i).margin_top));
            detailAssertTest("list.get(i).margin_bottom", String.valueOf(model.list.get(i).margin_bottom));
            detailAssertTest("list.get(i).margin_lr", String.valueOf(model.list.get(i).margin_lr));

//            detailAssertTest("list.get(i).layout", model.list.get(i).layout);
            detailAssertTest("list.get(i).auto", model.list.get(i).auto);
            detailAssertTest("list.get(i).interval", String.valueOf(model.list.get(i).interval));
            detailAssertTest("list.get(i).dots", model.list.get(i).dots);
            detailAssertTest("list.get(i).width", String.valueOf(model.list.get(i).width));
            detailAssertTest("list.get(i).height", String.valueOf(model.list.get(i).height));
            detailAssertTest("list.get(i).comment", model.list.get(i).comment);
            detailAssertTest("list.get(i).list", model.list.get(i).list);
            for (int j = 0; j < model.list.get(i).list.size(); j++) {
                detailAssertTest("list.get(i).list.get(j).image", String.valueOf(model.list.get(i).list.get(j).image));
//                detailAssertTest("list.get(i).list.get(j).image.url", model.list.get(i).list.get(j).image.url);
//                detailAssertTest("list.get(i).list.get(j).image.w", model.list.get(i).list.get(j).image.w);
//                detailAssertTest("list.get(i).list.get(j).image.h", model.list.get(i).list.get(j).image.h);
//                detailAssertTest("list.get(i).list.get(j).link", model.list.get(i).list.get(j).link);
            }
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).active", model.list.get(i).active);
//            detailAssertTest("list.get(i).flow_code", model.list.get(i).flow_code);
        }
        detailAssertTest("info", String.valueOf(model.info));
        detailAssertTest("info.title", model.info.title);
//        detailAssertTest("info.bg_color", model.info.bg_color);
//        detailAssertTest("info.foot_text", model.info.foot_text);
        detailAssertTest("info.share_title", model.info.share_title);
//        detailAssertTest("info.share_desc", model.info.share_desc);
//        detailAssertTest("info.share_link", model.info.share_link);
        detailAssertTest("info.is_mini", model.info.is_mini);
//        detailAssertTest("info.share_img", model.info.share_img);
//        detailAssertTest("info.share_induce", model.info.share_induce);
//        detailAssertTest("info.floats", model.info.floats);
        for (int i = 0; i < model.info.floats.size(); i++) {
            detailAssertTest("info.floats.get(i).enable", model.info.floats.get(i).enable);
//            detailAssertTest("info.floats.get(i).flow", model.info.floats.get(i).flow);
            detailAssertTest("info.floats.get(i).width", model.info.floats.get(i).width);
            detailAssertTest("info.floats.get(i).height", model.info.floats.get(i).height);
            detailAssertTest("info.floats.get(i).bottom", model.info.floats.get(i).bottom);
            detailAssertTest("info.floats.get(i).right", model.info.floats.get(i).right);
            detailAssertTest("info.floats.get(i).comment", model.info.floats.get(i).comment);
            detailAssertTest("info.floats.get(i).icon", String.valueOf(model.info.floats.get(i).icon));
            detailAssertTest("info.floats.get(i).icon.image", String.valueOf(model.info.floats.get(i).icon.image));
            detailAssertTest("info.floats.get(i).icon.image.url", model.info.floats.get(i).icon.image.url);
            detailAssertTest("info.floats.get(i).icon.image.w", model.info.floats.get(i).icon.image.w);
            detailAssertTest("info.floats.get(i).icon.image.h", model.info.floats.get(i).icon.image.h);
//            detailAssertTest("info.floats.get(i).icon.link", model.info.floats.get(i).icon.link);
            detailAssertTest("info.floats.get(i).type", model.info.floats.get(i).type);
            detailAssertTest("info.floats.get(i).id", model.info.floats.get(i).id);
            detailAssertTest("info.floats.get(i).active", model.info.floats.get(i).active);
            detailAssertTest("info.floats.get(i).margin_top", String.valueOf(model.info.floats.get(i).margin_top));
            detailAssertTest("info.floats.get(i).margin_bottom", String.valueOf(model.info.floats.get(i).margin_bottom));
            detailAssertTest("info.floats.get(i).margin_lr", String.valueOf(model.info.floats.get(i).margin_lr));
        }


    }
}
