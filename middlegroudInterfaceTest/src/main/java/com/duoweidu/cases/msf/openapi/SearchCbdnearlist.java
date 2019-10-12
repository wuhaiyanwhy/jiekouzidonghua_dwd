package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.SearchCbdnearlistData;
import org.testng.annotations.Test;

public class SearchCbdnearlist extends MsfInterfaceTest {

    private SearchCbdnearlistData model;

    @Test(dependsOnGroups = "loginTrue",description = "附近美食-商圈搜索（按地址位置）")
    public void searchCbdnearlist() {
        setUrl("search.cbdnearlist.uri");
        process(true,true);
        model = sparseJson(SearchCbdnearlistData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("total_page", model.total_page);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).zone_id", model.list.get(i).zone_id);
            assertNotNull("list.get(i).address", model.list.get(i).address);
            assertNotEmpty("list.get(i).lng", model.list.get(i).lng);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
            assertNotEmpty("list.get(i).is_hot", model.list.get(i).is_hot);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);
            assertNotNull("list.get(i).weight", model.list.get(i).weight);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).location.lon", model.list.get(i).location.lon);
            assertNotEmpty("list.get(i).location.lat", model.list.get(i).location.lat);
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).lat", model.list.get(i).lat);
            assertNotEmpty("list.get(i).status", model.list.get(i).status);

        }
    }
}
