package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.ActivitySharedetailData;
import org.testng.annotations.Test;

public class ActivitySharedetail extends MsfInterfaceTest {

    private ActivitySharedetailData model;

    @Test(description = "活动分享详情接口")
    public void activitySharedetail() {
        setUrl("activity.sharedetail.uri");
        param = "activity_id=" + SqlDetail.getInstance().getParamValue("activity_id");
        process(true,false);
        model = sparseJson(ActivitySharedetailData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertEquals("activity_id", model.activity_id, Integer.parseInt(SqlDetail.getInstance().getParamValue("activity_id")));
        assertNotNull("source_type", model.source_type);
        assertNotNull("online_status", model.online_status);
        assertNotEmpty("item_name", model.item_name);
        assertNotEmpty("item_pic", model.item_pic);
        assertNotEmpty("market_price", model.market_price);
        assertNotNull("left_stock", model.left_stock);
        assertNotEmpty("branch_id", model.branch_id);
        assertNotEmpty("start_price", model.start_price);
        assertNotEmpty("floor_price", model.floor_price);
        assertNotEmpty("current_price", model.current_price);
        assertNotNull("bargain_range", model.bargain_range);
        assertNotNull("bargain_count", model.bargain_count);
        assertNotEmpty("is_bargained", model.is_bargained);
        assertNotNull("reduce", model.reduce);
        assertNotEmpty("is_sold", model.is_sold);
        assertNotEmpty("branch.id", model.branch.id);
        assertNotEmpty("branch.branch_name", model.branch.branch_name);
        assertNotEmpty("branch.branch_head_pic", model.branch.branch_head_pic);
        assertNotEmpty("branch.description", model.branch.description);
        assertNotEmpty("branch.address", model.branch.address);
        assertNotNull("branch.address_short", model.branch.address_short);
        assertNotNull("branch.phone", model.branch.phone);
        assertNotEmpty("branch.lat", model.branch.lat);
        assertNotEmpty("branch.lng", model.branch.lng);
        assertNotEmpty("branch.zone_id", model.branch.zone_id);
        assertNotNull("branch.article_count", model.branch.article_count);
        assertNotNull("branch.star", model.branch.star);

        assertNotNull("bargain_users", model.bargain_users);
        for (int i = 0; i < model.bargain_users.size(); i++) {
            assertNotEmpty("bargain_users.get(i).id", model.bargain_users.get(i).id);
            assertNotEmpty("bargain_users.get(i).nickname", model.bargain_users.get(i).nickname);
            assertNotEmpty("bargain_users.get(i).avatar", model.bargain_users.get(i).avatar);
            assertNotNull("bargain_users.get(i).quality_user", model.bargain_users.get(i).quality_user);

        }

    }
}
