package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.BranchCatlistData;
import org.testng.annotations.Test;

public class BranchCatlist extends MsfInterfaceTest {

    private BranchCatlistData model;

    @Test(description = "门店分类列表")
    public void branchCatlist() {
        setUrl("branch.catlist.uri");
        process(true,false);
        model = sparseJson(BranchCatlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);
            assertNotNull("list.get(i).weight", model.list.get(i).weight);
            assertNotNull("list.get(i).zone_id", model.list.get(i).zone_id);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);

        }
    }
}
