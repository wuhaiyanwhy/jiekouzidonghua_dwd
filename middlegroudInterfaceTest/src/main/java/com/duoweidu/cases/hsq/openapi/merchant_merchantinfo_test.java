package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.MerchantMerchantinfoData;
import org.testng.annotations.Test;

public class merchant_merchantinfo_test extends HsqInterfaceTest {

    private MerchantMerchantinfoData model;

    @Test(description = "获取商户信息")
    public void merchant_merchantinfo_true() {
        setUrl("merchant.merchantinfo.uri");
        param = "merchantId="+ SqlDetail.getInstance().getParamValue("merchantId");
        process(true,false);
        model = sparseJson(MerchantMerchantinfoData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("roles", model.roles);
        detailAssertTest("name", model.name);
//        detailAssertTest("tinyurl", model.tinyurl);
        detailAssertTest("logo", model.logo);
//        detailAssertTest("description", model.description);
        detailAssertTest("online_sku_cnt", String.valueOf(model.online_sku_cnt));
        detailAssertTest("enabled", model.enabled);
        detailAssertTest("is_free_base_weight", String.valueOf(model.is_free_base_weight));
//        detailAssertTest("notice", model.notice);
//        detailAssertTest("udesk_merchant_id", model.udesk_merchant_id);
        detailAssertTest("brandList", model.brandList);
        for (int i = 0; i < model.brandList.size(); i++) {
//            detailAssertTest("id", model.brandList.get(i).id);
            detailAssertTest("name", model.brandList.get(i).name);
            detailAssertTest("logo", model.brandList.get(i).logo);

        }
        detailAssertTest("province", model.province);
        detailAssertTest("is_like", model.is_like);
//        detailAssertTest("coupons", model.coupons);
//        detailAssertTest("activityList", model.activityList);
        detailAssertTest("sourceType", model.sourceType);


    }
}
