package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.model.msf.ActivityListData;
import org.testng.annotations.Test;


public class ActivityList extends MsfInterfaceTest {

    private ActivityListData model;

    @Test(description = "活动列表")
    public void ActivityList() {
        setUrl("activity.list.uri");
        process(true,true);
        model = sparseJson(ActivityListData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("total_page", model.total_page);
        assertNotEmpty("total_cnt", model.total_cnt);
        assertNotEmpty("category", model.category);

        for (int i = 0; i < model.category.size(); i++) {
            assertNotNull("category.get(i).id", model.category.get(i).id);
            assertNotNull("category.get(i).name", model.category.get(i).name);
        }
        assertNotEmpty("list", model.list);
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).activity_id", model.list.get(i).activity_id);
            assertNotEmpty("list.get(i).item_name", model.list.get(i).item_name);
            assertNotEmpty("list.get(i).item_pic", model.list.get(i).item_pic);
            assertNotEmpty("list.get(i).market_price", model.list.get(i).market_price);
            assertNotEmpty("list.get(i).start_price", model.list.get(i).start_price);
            assertNotEmpty("list.get(i).floor_price", model.list.get(i).floor_price);
            assertNotEmpty("list.get(i).current_price", model.list.get(i).current_price);
            assertNotNull("list.get(i).bargain_range", model.list.get(i).bargain_range);
            assertNotNull("list.get(i).bargain_count", model.list.get(i).bargain_count);
            assertNotEmpty("list.get(i).branch_name", model.list.get(i).branch_name);
            assertNotEmpty("list.get(i).distance", model.list.get(i).distance);
            assertNotNull("list.get(i).is_bargained", model.list.get(i).is_bargained);
            assertNotNull("list.get(i).is_sold", model.list.get(i).is_sold);
            assertNotNull("list.get(i).is_new", model.list.get(i).is_new);

        }

    }
}
