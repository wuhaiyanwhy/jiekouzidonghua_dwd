package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.NationCitylistModel;
import org.testng.annotations.Test;

public class nation_citylist_test extends HsqInterfaceTest {

    private NationCitylistModel model;

    @Test(description = "获取城市列表")
    public void nation_citylist_true() {
        setUrl("nation.citylist.uri");
        param = "provinceId=2";
        process(true,true);
        model = sparseJson(NationCitylistModel.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).city", model.list.get(i).city);
            detailAssertTest("list.get(i).province_id", model.list.get(i).province_id);
            detailAssertTest("list.get(i).amap_id", model.list.get(i).amap_id);
            detailAssertTest("list.get(i).is_hot", String.valueOf(model.list.get(i).is_hot));
            detailAssertTest("list.get(i).pin_yin", model.list.get(i).pin_yin);

        }
    }
}
