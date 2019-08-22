package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.MarketSpecialtopiccomponentgroupskulistData;
import org.testng.annotations.Test;

public class market_specialtopiccomponentgroupskulist_test extends HsqInterfaceTest {

    private MarketSpecialtopiccomponentgroupskulistData model;

    @Test(description = "五福页尾铺品")
    public void market_specialtopiccomponentgroupskulist_true() {
        setUrl("market.specialtopiccomponentgroupskulist.uri");
        param = "componentGroupId=" + SqlDetail.getInstance().getParamValue("componentGroupId") + "&pageNum=1&pageLimit=20&topicCode=" + SqlDetail.getInstance().getParamValue("wufuTopicCode");
        process(true, true);
        model = sparseJson(MarketSpecialtopiccomponentgroupskulistData.class);
        detailassert();
    }

    private void detailassert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).priority", model.list.get(i).priority);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
            detailAssertTest("list.get(i).sku_pic", model.list.get(i).sku_pic);
            detailAssertTest("list.get(i).pin_activities_id", model.list.get(i).pin_activities_id);
            detailAssertTest("list.get(i).couple_title", model.list.get(i).couple_title);
            detailAssertTest("list.get(i).couple_price", model.list.get(i).couple_price);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
            detailAssertTest("list.get(i).sub_title", model.list.get(i).sub_title);
            detailAssertTest("list.get(i).can_bought", model.list.get(i).can_bought);
            detailAssertTest("list.get(i).left_stock", String.valueOf(model.list.get(i).left_stock));
//            detailAssertTest("list.get(i).selled_stock", model.list.get(i).selled_stock);
            detailAssertTest("list.get(i).count_limit", model.list.get(i).count_limit);
//            detailAssertTest("list.get(i).corner_mark_image", model.list.get(i).corner_mark_image);
//            detailAssertTest("list.get(i).master_label", model.list.get(i).master_label);
//            detailAssertTest("list.get(i).slave_label", model.list.get(i).slave_label);
            detailAssertTest("list.get(i).updated_at", model.list.get(i).updated_at);
            detailAssertTest("list.get(i).group_price_activity", String.valueOf(model.list.get(i).group_price_activity));

        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);

    }

}
