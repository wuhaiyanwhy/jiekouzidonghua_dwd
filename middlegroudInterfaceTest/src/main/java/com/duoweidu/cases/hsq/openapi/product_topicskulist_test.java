package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ProductTopicskulistData;
import com.duoweidu.utils.ConfigFileUrl;
import org.testng.annotations.Test;

public class product_topicskulist_test extends HsqInterfaceTest {

    private ProductTopicskulistData model;

    @Test(description = "获取专题商品列表")
    public void product_topicskulist_true() {
        setUrl("product.topicskulist.uri");
        param = "topicCode=" + SqlDetail.getInstance().getParamValue("topicCode");
        process(true,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            model = sparseJson(ProductTopicskulistData.class);
            detailAssert();
        }
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            detailAssertTest("list.get(i).id", model.list.get(i).id);
            detailAssertTest("list.get(i).topic_id", model.list.get(i).topic_id);
            detailAssertTest("list.get(i).sku_id", model.list.get(i).sku_id);
            detailAssertTest("list.get(i).sku_name", model.list.get(i).sku_name);
            detailAssertTest("list.get(i).sku_pic", model.list.get(i).sku_pic);
            detailAssertTest("list.get(i).type", model.list.get(i).type);
            detailAssertTest("list.get(i).pinActivityId", model.list.get(i).pinActivityId);
            detailAssertTest("list.get(i).title", model.list.get(i).title);
            detailAssertTest("list.get(i).single_price", model.list.get(i).single_price);
            detailAssertTest("list.get(i).group_price", model.list.get(i).group_price);
            detailAssertTest("list.get(i).count_limit", model.list.get(i).count_limit);
            detailAssertTest("list.get(i).merchant_id", model.list.get(i).merchant_id);
            detailAssertTest("list.get(i).merchant_type", model.list.get(i).merchant_type);
            detailAssertTest("list.get(i).market_price", model.list.get(i).market_price);
        }
        detailAssertTest("totalCnt", model.totalCnt);
        detailAssertTest("totalPage", model.totalPage);
    }
}
