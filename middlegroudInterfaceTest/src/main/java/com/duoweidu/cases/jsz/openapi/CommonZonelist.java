package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.model.jsz.CommonZonelistResult;
import org.testng.annotations.Test;

public class CommonZonelist extends JszInterfaceTest {

    private CommonZonelistResult model;

    @Test(description = "城市列表")
    public void commonZonelist() {
        setUrl("common.zonelist.uri");
        process(false, false);
        model = sparseJsonResult(CommonZonelistResult.class);
        detailAssert();
    }

    private void detailAssert() {
        for(int i = 0; i < model.data.size(); i++) {
            detailAssertTest("model.data.id",model.data.get(i).id);
            detailAssertTest("name",model.data.get(i).name);
            detailAssertTest("address",model.data.get(i).address);
            detailAssertTest("lng",model.data.get(i).lng);
            detailAssertTest("lat",model.data.get(i).lat);
            detailAssertTest("baidu_city_id",model.data.get(i).baidu_city_id);
            detailAssertTest("province_name",model.data.get(i).province_name);
            detailAssertTest("amap_city_id",model.data.get(i).amap_city_id);
        }
    }
}
