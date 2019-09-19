package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonLocateData;
import org.testng.annotations.Test;

public class CommonLocate extends MsfInterfaceTest {

    private CommonLocateData model;

    @Test(description = "获取定位")
    public void commonLocate() {
        setUrl("common.locate.uri");
        process(true,false);
        model = sparseJson(CommonLocateData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("baidu_city_id", model.baidu_city_id);
        assertNotEmpty("amap_city_id", model.amap_city_id);
        assertNotEmpty("name", model.name);
        assertNotEmpty("address", model.address);
        assertNotEmpty("lng", model.lng);
        assertNotEmpty("lat", model.lat);
        assertNotNull("weight", model.weight);
        assertNotNull("launched_at", model.launched_at);
        assertNotEmpty("first_pin_yin", model.first_pin_yin);
        assertNotEmpty("is_hot", model.is_hot);
        assertNotEmpty("status", model.status);
        assertNotEmpty("cover", model.cover);
        assertNotEmpty("province_name", model.province_name);
        assertNotEmpty("zone_id", model.zone_id);
    }
}
