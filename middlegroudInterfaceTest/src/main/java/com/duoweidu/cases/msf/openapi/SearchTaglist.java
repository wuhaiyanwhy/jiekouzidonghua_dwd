package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.SearchTaglistData;
import org.testng.annotations.Test;

public class SearchTaglist extends MsfInterfaceTest {

    private SearchTaglistData model;

    @Test(dependsOnGroups = "loginTrue",description = "搜索标签")
    public void searchTaglist() {
        setUrl("search.taglist.uri");
        param = "name=" + SqlDetail.getInstance().getParamValue(0, "tagName");
        process(true,true);
        model = sparseJson(SearchTaglistData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("totalPage", model.totalPage);
        assertNotEmpty("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).name", model.list.get(i).name);
            assertNotNull("list.get(i).remark", model.list.get(i).remark);
            assertNotEmpty("list.get(i).status", model.list.get(i).status);
            assertNotNull("list.get(i).weight", model.list.get(i).weight);
            assertNotEmpty("list.get(i).created_at", model.list.get(i).created_at);
            assertNotEmpty("list.get(i).updated_at", model.list.get(i).updated_at);
        }
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("total_page", model.total_page);
    }
}
