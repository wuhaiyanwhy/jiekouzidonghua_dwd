package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonAppconfigData;
import org.testng.annotations.Test;

public class CommonAppconfig extends MsfInterfaceTest {

    private CommonAppconfigData model;

    @Test(description = "app初始化配置")
    public void commonAppconfig() {
        setUrl("common.appconfig.uri");
        process(true,false);
        model = sparseJson(CommonAppconfigData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("default_zone.id", model.default_zone.id);
        assertNotEmpty("default_zone.baidu_city_id", model.default_zone.baidu_city_id);
        assertNotEmpty("default_zone.amap_city_id", model.default_zone.amap_city_id);
        assertNotEmpty("default_zone.name", model.default_zone.name);
        assertNotEmpty("default_zone.address", model.default_zone.address);
        assertNotEmpty("default_zone.lng", model.default_zone.lng);
        assertNotEmpty("default_zone.lat", model.default_zone.lat);
        assertNotNull("default_zone.weight", model.default_zone.weight);
        assertNotNull("default_zone.launched_at", model.default_zone.launched_at);
        assertNotEmpty("default_zone.first_pin_yin", model.default_zone.first_pin_yin);
        assertNotNull("default_zone.is_hot", model.default_zone.is_hot);
        assertNotEmpty("default_zone.status", model.default_zone.status);
        assertNotEmpty("default_zone.cover", model.default_zone.cover);
        assertNotEmpty("default_zone.province_name", model.default_zone.province_name);
        assertNotEmpty("default_zone.zone_id", model.default_zone.zone_id);
        assertNotEmpty("update.id", model.update.id);
        assertNotEmpty("update.platform", model.update.platform);
        assertNotEmpty("update.version_code", model.update.version_code);
        assertNotNull("update.lowest_code", model.update.lowest_code);
        assertNotEmpty("update.name", model.update.name);
        assertNotEmpty("update.title", model.update.title);
        assertNotEmpty("update.description", model.update.description);
        assertNotEmpty("update.url", model.update.url);
        assertNotEmpty("update.force_update", model.update.force_update);
        assertNotNull("update.status", model.update.status);
        assertNotEmpty("update.decode", model.update.decode);
        assertNotEmpty("update.created_at", model.update.created_at);
        assertNotEmpty("update.updated_at", model.update.updated_at);
        assertNotEmpty("update.can_update", model.update.can_update);
        assertNotNull("unread", model.unread);
        assertNotEmpty("term_of_service", model.term_of_service);
        assertNotEmpty("protocols.user_service", model.protocols.user_service);
        assertNotEmpty("protocols.user_privacy", model.protocols.user_privacy);
        assertNotEmpty("protocols.about_us", model.protocols.about_us);
        assertNotEmpty("tongdun_fingerprint", model.tongdun_fingerprint);
        assertNotEmpty("honey.article_publish", model.honey.article_publish);
        assertNotEmpty("honey.article_recommend", model.honey.article_recommend);
        assertNotEmpty("honey.article_interactive", model.honey.article_interactive);
        assertNotEmpty("honey.article_branch_first", model.honey.article_branch_first);
        assertNotEmpty("honey.article_user_first", model.honey.article_user_first);
        assertNotEmpty("honey.article_user_first", model.honey.article_user_first);

    }

}
