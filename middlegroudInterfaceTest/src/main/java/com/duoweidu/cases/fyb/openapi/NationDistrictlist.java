package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.NationDistrictlistData;
import org.testng.annotations.Test;

public class NationDistrictlist extends FybInterfaceTest {

    private NationDistrictlistData model;

    @Test(description = "获取行政区县列表")
    public void nationDistrictlist() {
        setUrl("nation.districtlist.uri");
        param = "cityId=2";
        process(true,true);
        model = sparseJson(NationDistrictlistData.class);
        detailAssert();

    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).district", model.list.get(i).district);
            assertNotEmpty("list.get(i).city_id", model.list.get(i).city_id);

        }
    }
}
