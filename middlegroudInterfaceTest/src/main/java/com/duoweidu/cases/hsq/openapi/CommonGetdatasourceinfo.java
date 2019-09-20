package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.CommonGetdatasourceinfoData;
import org.testng.annotations.Test;

public class CommonGetdatasourceinfo extends HsqInterfaceTest {

    private CommonGetdatasourceinfoData model;

    @Test(description = "获取数据源信息")
    public void commonGetdatasourceinfo() {
        setUrl("common.getdatasourceinfo.uri");
        param = "sourceId=" + SqlDetail.getInstance().getParamValue("sourceId");
        process(true, true);
        model = sparseJson(CommonGetdatasourceinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).category_id", model.list.get(i).category_id);
            detailAssertTest("list.get(i).biz_id", model.list.get(i).biz_id);
            detailAssertTest("list.get(i).feature", model.list.get(i).feature);
            detailAssertTest("list.get(i).topping", String.valueOf(model.list.get(i).topping));
            detailAssertTest("list.get(i).name", model.list.get(i).name);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).sku_price", model.list.get(i).sku_price);
            detailAssertTest("list.get(i).thumbnail", model.list.get(i).thumbnail);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
//            detailAssertTest("list.get(i).enabled", model.list.get(i).enabled);
            detailAssertTest("list.get(i).expired_date", model.list.get(i).expired_date);
            detailAssertTest("list.get(i).left_stock", model.list.get(i).left_stock);
//            detailAssertTest("list.get(i).product_id", model.list.get(i).product_id);
            detailAssertTest("list.get(i).all_stock", model.list.get(i).all_stock);
            detailAssertTest("list.get(i).title", model.list.get(i).title);
            detailAssertTest("list.get(i).price", model.list.get(i).price);
//            detailAssertTest("list.get(i).sub_title", model.list.get(i).sub_title);
            detailAssertTest("list.get(i).merchant_type", model.list.get(i).merchant_type);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).pin_id", model.list.get(i).pin_id);
            detailAssertTest("list.get(i).can_bought", model.list.get(i).can_bought);
//            detailAssertTest("list.get(i).tags", model.list.get(i).tags);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
            detailAssertTest("list.get(i).merchant_name", model.list.get(i).merchant_name);
            detailAssertTest("list.get(i).link", model.list.get(i).link);
            detailAssertTest("list.get(i).subscribed", model.list.get(i).subscribed);

        }
//        detailAssertTest("tabs", model.tabs);
        detailAssertTest("totalNum", model.totalNum);
        detailAssertTest("totalPage", model.totalPage);
        detailAssertTest("currentPage", model.currentPage);
        detailAssertTest("channelError", model.channelError);

    }
}
