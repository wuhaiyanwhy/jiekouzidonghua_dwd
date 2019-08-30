package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.msf.BranchDetailData;
import org.testng.annotations.Test;

public class BranchDetail extends MsfInterfaceTest {

    private BranchDetailData model;

    @Test(description = "门店详情")
    public void branchDetail() {
        setUrl("branch.detail.uri");
        param = "id=" + SqlDetail.getInstance().getParamValue("branch_id");
        process(true,false);
        model = sparseJson(BranchDetailData.class);
        detailassert();
    }

    private void detailassert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("merchant_id", model.merchant_id);
        assertNotNull("seller_id", model.seller_id);
        assertNotEmpty("branch_name", model.branch_name);
        assertNotEmpty("branch_head_pic", model.branch_head_pic);
        assertNotEmpty("contactor", model.contactor);
        assertNotNull("phone", model.phone);
        assertNotNull("mobile", model.mobile);
        assertNotNull("contract_no", model.contract_no);
        assertNotNull("hygienic_license", model.hygienic_license);
        assertNotEmpty("lng", model.lng);
        assertNotEmpty("lat", model.lat);
        assertNotEmpty("address", model.address);
        assertNotNull("address_short", model.address_short);
        assertNotNull("cbd_id", model.cbd_id);
        assertNotEmpty("zone_id", model.zone_id);
        assertNotEmpty("cat_id", model.cat_id);
        assertNotNull("description", model.description);
        assertNotNull("source_type", model.source_type);
        assertNotNull("redeem_time", model.redeem_time);
        assertNotNull("freeze_period", model.freeze_period);
        assertNotNull("is_recommend", model.is_recommend);
        assertNotNull("out_link", model.out_link);
        assertNotEmpty("branch_code", model.branch_code);
        assertNotEmpty("qr_code", model.qr_code);
        assertNotNull("status", model.status);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("updated_at", model.updated_at);
        assertNotEmpty("cat_info.id", model.cat_info.id);
        assertNotEmpty("cat_info.name", model.cat_info.name);
        assertNotNull("cat_info.weight", model.cat_info.weight);
        assertNotNull("cat_info.type", model.cat_info.type);
        assertNotNull("cat_info.zone_id", model.cat_info.zone_id);
        assertNotNull("cat_info.status", model.cat_info.status);
        assertNotEmpty("cat_info.created_at", model.cat_info.created_at);
        assertNotEmpty("cat_info.updated_at", model.cat_info.updated_at);
        if (model.activity_list.size() > 0) {
            for (int i = 0; i < model.activity_list.size(); i++) {
                assertNotEmpty("activity_list.get(i).activity_id", model.activity_list.get(i).activity_id);
                assertNotEmpty("activity_list.get(i).item_name", model.activity_list.get(i).item_name);
                assertNotEmpty("activity_list.get(i).item_pic", model.activity_list.get(i).item_pic);
                assertNotEmpty("activity_list.get(i).market_price", model.activity_list.get(i).market_price);
                assertNotEmpty("activity_list.get(i).start_price", model.activity_list.get(i).start_price);
                assertNotEmpty("activity_list.get(i).floor_price", model.activity_list.get(i).floor_price);
                assertNotEmpty("activity_list.get(i).current_price", model.activity_list.get(i).current_price);
                assertNotEmpty("activity_list.get(i).bargain_range", model.activity_list.get(i).bargain_range);
                assertNotEmpty("activity_list.get(i).left_stock", model.activity_list.get(i).left_stock);
                assertNotEmpty("activity_list.get(i).branch_name", model.activity_list.get(i).branch_name);
                assertNotNull("activity_list.get(i).bargain_count", model.activity_list.get(i).bargain_count);
                assertNotEmpty("activity_list.get(i).is_bargained", model.activity_list.get(i).is_bargained);
                assertNotEmpty("activity_list.get(i).is_sold", model.activity_list.get(i).is_sold);
                assertNotEmpty("activity_list.get(i).distance", model.activity_list.get(i).distance);
            }
        }

        for (int i = 0; i < model.pic_list.size(); i++) {
            assertNotEmpty("pic_list.get(i).id", model.pic_list.get(i).id);
            assertNotEmpty("pic_list.get(i).article_id", model.pic_list.get(i).article_id);
            assertNotEmpty("pic_list.get(i).pic", model.pic_list.get(i).pic);
            assertNotEmpty("pic_list.get(i).width", model.pic_list.get(i).width);
            assertNotEmpty("pic_list.get(i).height", model.pic_list.get(i).height);
            assertNotEmpty("pic_list.get(i).status", model.pic_list.get(i).status);
            assertNotEmpty("pic_list.get(i).created_at", model.pic_list.get(i).created_at);
            assertNotEmpty("pic_list.get(i).updated_at", model.pic_list.get(i).updated_at);

        }

        assertNotEmpty("distance", model.distance);
    }
}
