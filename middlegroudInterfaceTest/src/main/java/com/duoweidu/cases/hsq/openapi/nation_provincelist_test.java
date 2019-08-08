package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.NationProvincelistData;
import org.testng.annotations.Test;

public class nation_provincelist_test extends HsqInterfaceTest {

    private NationProvincelistData model;

    @Test(dependsOnGroups = "loginTrue",description = "获取省份列表")
    public void nation_provincelist_true() {
        setUrl("nation.provincelist.uri");
        process(true,true);
        model = sparseJson(NationProvincelistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).province", model.list.get(i).province);
            detailAssertTest("list.get(i).enabled", model.list.get(i).enabled);
        }
    }

}
