package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.SearchBranchData;
import org.testng.annotations.Test;

public class SearchBranch extends MsfInterfaceTest {

    private SearchBranchData model;

    @Test(dependsOnGroups = "loginTrue",description = "地址搜索")
    public void searchBranch() {
        setUrl("search.branch.uri");
        process(true,false);
        model = sparseJson(SearchBranchData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("totalCnt", model.totalCnt);
        assertNotEmpty("totalPage", model.totalPage);
        assertNotEmpty("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).branch_name", model.list.get(i).branch_name);
            assertNotEmpty("list.get(i).branch_head_pic", model.list.get(i).branch_head_pic);
            assertNotNull("list.get(i).contactor", model.list.get(i).contactor);
            assertNotNull("list.get(i).phone", model.list.get(i).phone);
            assertNotEmpty("list.get(i).lng", model.list.get(i).lng);
            assertNotEmpty("list.get(i).lat", model.list.get(i).lat);
            assertNotEmpty("list.get(i).address", model.list.get(i).address);
            assertNotNull("list.get(i).cbd_id", model.list.get(i).cbd_id);
            assertNotNull("list.get(i).zone_id", model.list.get(i).zone_id);
            assertNotNull("list.get(i).cat_id", model.list.get(i).cat_id);
            assertNotNull("list.get(i).description", model.list.get(i).description);
            assertNotEmpty("list.get(i).status", model.list.get(i).status);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
            assertNotEmpty("list.get(i).location.lat", model.list.get(i).location.lat);
            assertNotEmpty("list.get(i).location.lon", model.list.get(i).location.lon);
            assertNotNull("list.get(i).star", model.list.get(i).star);
            assertNotNull("list.get(i).article_count", model.list.get(i).article_count);
//            assertNotEmpty("list.get(i).cat_info.id", model.list.get(i).cat_info.id);
//            assertNotEmpty("list.get(i).cat_info.name", model.list.get(i).cat_info.name);
//            assertNotEmpty("list.get(i).cat_info.weight", model.list.get(i).cat_info.weight);
//            assertNotEmpty("list.get(i).cat_info.type", model.list.get(i).cat_info.type);
//            assertNotNull("list.get(i).cat_info.zone_id", model.list.get(i).cat_info.zone_id);
//            assertNotEmpty("list.get(i).cat_info.status", model.list.get(i).cat_info.status);
//            assertNotEmpty("list.get(i).cat_info.created_at", model.list.get(i).cat_info.created_at);
//            assertNotEmpty("list.get(i).cat_info.updated_at", model.list.get(i).cat_info.updated_at);
            assertNotEmpty("list.get(i).distance", model.list.get(i).distance);
        }
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("total_page", model.total_page);
        assertNotEmpty("near", model.near);
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

    }
}
