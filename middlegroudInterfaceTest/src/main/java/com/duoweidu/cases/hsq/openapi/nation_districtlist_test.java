package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.NationDistrictlistData;
import org.testng.annotations.Test;

public class nation_districtlist_test extends HsqInterfaceTest {

    private NationDistrictlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取行政区县列表")
    public void nation_districtlist_true() {
        setUrl("nation.districtlist.uri");
        param = "cityId=2";
        process(true,true);
        model = sparseJson(NationDistrictlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).district", model.list.get(i).district);
            detailAssertTest("list.get(i).city_id", model.list.get(i).city_id);
        }
    }

}
