package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.CommonZonelistData;
import org.testng.annotations.Test;

public class CommonZonelist extends MsfInterfaceTest {

    private CommonZonelistData model;

    @Test(description = "城市列表")
    public void commonZonelist() {
        setUrl("common.zonelist.uri");
        process(true,false);
        model = sparseJson(CommonZonelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("zonelist", model.zonelist);
        assertNotEmpty("hotlist", model.hotlist);
        for (int i = 0; i < model.zonelist.size(); i++) {
            assertNotEmpty("zonelist.get(i).id", model.zonelist.get(i).id);
            assertNotEmpty("zonelist.get(i).baidu_city_id", model.zonelist.get(i).baidu_city_id);
            assertNotEmpty("zonelist.get(i).amap_city_id", model.zonelist.get(i).amap_city_id);
            assertNotEmpty("zonelist.get(i).name", model.zonelist.get(i).name);
            assertNotEmpty("zonelist.get(i).address", model.zonelist.get(i).address);
            assertNotEmpty("zonelist.get(i).lng", model.zonelist.get(i).lng);
            assertNotEmpty("zonelist.get(i).lat", model.zonelist.get(i).lat);
            assertNotNull("zonelist.get(i).weight", model.zonelist.get(i).weight);
            assertNotNull("zonelist.get(i).launched_at", model.zonelist.get(i).launched_at);
            assertNotEmpty("zonelist.get(i).first_pin_yin", model.zonelist.get(i).first_pin_yin);
            assertNotEmpty("zonelist.get(i).is_hot", model.zonelist.get(i).is_hot);
            assertNotEmpty("zonelist.get(i).status", model.zonelist.get(i).status);
            assertNotNull("zonelist.get(i).cover", model.zonelist.get(i).cover);
            assertNotEmpty("zonelist.get(i).province_name", model.zonelist.get(i).province_name);
        }
        for (int i = 0; i < model.hotlist.size(); i++) {
            assertNotEmpty("hotlist.get(i).id", model.hotlist.get(i).id);
            assertNotEmpty("hotlist.get(i).baidu_city_id", model.hotlist.get(i).baidu_city_id);
            assertNotEmpty("hotlist.get(i).amap_city_id", model.hotlist.get(i).amap_city_id);
            assertNotEmpty("hotlist.get(i).name", model.hotlist.get(i).name);
            assertNotEmpty("hotlist.get(i).address", model.hotlist.get(i).address);
            assertNotEmpty("hotlist.get(i).lng", model.hotlist.get(i).lng);
            assertNotEmpty("hotlist.get(i).lat", model.hotlist.get(i).lat);
            assertNotNull("hotlist.get(i).weight", model.hotlist.get(i).weight);
            assertNotNull("hotlist.get(i).launched_at", model.hotlist.get(i).launched_at);
            assertNotEmpty("hotlist.get(i).first_pin_yin", model.hotlist.get(i).first_pin_yin);
            assertNotEmpty("hotlist.get(i).is_hot", model.hotlist.get(i).is_hot);
            assertNotEmpty("hotlist.get(i).status", model.hotlist.get(i).status);
            assertNotEmpty("hotlist.get(i).cover", model.hotlist.get(i).cover);
            assertNotEmpty("hotlist.get(i).province_name", model.hotlist.get(i).province_name);
        }
    }
}
