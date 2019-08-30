package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ActivityDetailData;
import org.testng.annotations.Test;

public class ActivityDetail extends MsfInterfaceTest {

    private ActivityDetailData model;

    @Test(description = "活动详情")
    public void activityDetail() {
        setUrl("activity.detail.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
        model = sparseJson(ActivityDetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertEquals("activity_id", model.activity_id, Integer.parseInt(SqlDetail.getInstance().getParamValue("activity_id")));
        assertNotEmpty("source_type", model.source_type);
        assertNotEmpty("online_status", model.online_status);
        assertNotEmpty("start_price", model.start_price);
        assertNotEmpty("floor_price", model.floor_price);
        assertNotEmpty("current_price", model.current_price);
        assertNotEmpty("market_price", model.market_price);
        assertNotEmpty("tips", model.tips);
        assertNotEmpty("item_id", model.item_id);
        assertNotEmpty("branch_id", model.branch_id);
        assertNotNull("left_stock", model.left_stock);
        assertNotEmpty("item_pic", model.item_pic);
        assertNotEmpty("item_name", model.item_name);
        assertNotNull("description", model.description);
        assertNotEmpty("menus", model.menus);
        for (int i = 0; i < model.menus.size(); i++) {
            assertNotEmpty("menus.get(i).name", model.menus.get(i).name);
            assertNotEmpty("menus.get(i).items", model.menus.get(i).items);
            for (ActivityDetailData.MenusModel.ItemsModel items:
                    model.menus.get(i).items) {
                assertNotEmpty("items.name", items.name);
                assertNotEmpty("items.price", items.price);
            }
        }
        assertNotEmpty("pic_list", model.pic_list);
        assertNotEmpty("branch.id", model.branch.id);
        assertNotEmpty("branch.branch_name", model.branch.branch_name);
        assertNotEmpty("branch.branch_head_pic", model.branch.branch_head_pic);
        assertNotNull("branch.description", model.branch.description);
        assertNotEmpty("branch.address", model.branch.address);
        assertNotNull("branch.address_short", model.branch.address_short);
        assertNotNull("branch.phone", model.branch.phone);
        assertNotEmpty("branch.lat", model.branch.lat);
        assertNotEmpty("branch.lng", model.branch.lng);
        assertNotEmpty("branch.zone_id", model.branch.zone_id);
        assertNotNull("branch.article_count", model.branch.article_count);
        assertNotNull("branch.star", model.branch.star);
        assertNotNull("bargain_count", model.bargain_count);
        assertNotEmpty("special_tips", model.special_tips);
        for (int i = 0; i < model.special_tips.size(); i++) {
            assertNotEmpty("special_tips.get(i).text", model.special_tips.get(i).text);
            assertNotEmpty("special_tips.get(i).icon", model.special_tips.get(i).icon);

        }
        assertNotNull("tips_array", model.tips_array);
        assertNotEmpty("activity_sale_status", model.activity_sale_status);

    }
}
