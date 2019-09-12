package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.BranchNearcbdData;
import org.testng.annotations.Test;

public class BranchNearcbd extends MsfInterfaceTest {

    private BranchNearcbdData model;

    @Test(description = "地理位置")
    public void branchNearcbd() {
        setUrl("branch.nearcbd.uri");
        process(true,false);
        model = sparseJson(BranchNearcbdData.class);
        detailassert();
    }

    private void detailassert() {
        assertNotEmpty("near", model.near);
        assertNotEmpty("hot", model.hot);
        for (int i = 0; i < model.near.size(); i++) {
            assertNotEmpty("near.get(i).zone_id", model.near.get(i).zone_id);
            assertNotNull("near.get(i).address", model.near.get(i).address);
            assertNotEmpty("near.get(i).lng", model.near.get(i).lng);
            assertNotEmpty("near.get(i).updated_at", model.near.get(i).updated_at);
            assertNotEmpty("near.get(i).is_hot", model.near.get(i).is_hot);
            assertNotEmpty("near.get(i).name", model.near.get(i).name);
            assertNotEmpty("near.get(i).weight", model.near.get(i).weight);
            assertNotEmpty("near.get(i).created_at", model.near.get(i).created_at);
            assertNotEmpty("near.get(i).location.lon", model.near.get(i).location.lon);
            assertNotEmpty("near.get(i).location.lat", model.near.get(i).location.lat);
            assertNotEmpty("near.get(i).id", model.near.get(i).id);
            assertNotEmpty("near.get(i).lat", model.near.get(i).lat);
            assertNotEmpty("near.get(i).status", model.near.get(i).status);
        }

        for (int i = 0; i < model.hot.size(); i++) {
            assertNotEmpty("hot.get(i).id", model.hot.get(i).id);
            assertNotEmpty("hot.get(i).zone_id", model.hot.get(i).zone_id);
            assertNotEmpty("hot.get(i).name", model.hot.get(i).name);
            assertNotNull("hot.get(i).address", model.hot.get(i).address);
            assertNotEmpty("hot.get(i).lat", model.hot.get(i).lat);
            assertNotEmpty("hot.get(i).lng", model.hot.get(i).lng);
            assertNotNull("hot.get(i).weight", model.hot.get(i).weight);
            assertNotEmpty("hot.get(i).status", model.hot.get(i).status);
            assertNotEmpty("hot.get(i).is_hot", model.hot.get(i).is_hot);
            assertNotEmpty("hot.get(i).created_at", model.hot.get(i).created_at);
            assertNotEmpty("hot.get(i).updated_at", model.hot.get(i).updated_at);
        }
    }
}
