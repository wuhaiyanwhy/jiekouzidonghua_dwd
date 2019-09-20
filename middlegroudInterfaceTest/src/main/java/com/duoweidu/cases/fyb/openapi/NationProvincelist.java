package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.NationProvincelistData;
import org.testng.annotations.Test;

public class NationProvincelist extends FybInterfaceTest {

    private NationProvincelistData model;

    @Test(description = "获取省份列表")
    public void nationProvincelist() {
        setUrl("nation.provincelist.uri");
        process(true,true);
        model = sparseJson(NationProvincelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(0).id", model.list.get(0).id);
            assertNotEmpty("list.get(0).province", model.list.get(0).province);
            assertNotEmpty("list.get(0).enabled", model.list.get(0).enabled);

        }
    }
}
