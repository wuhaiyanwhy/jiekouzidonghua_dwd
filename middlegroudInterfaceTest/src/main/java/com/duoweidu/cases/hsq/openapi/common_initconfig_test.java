package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.CommonInitconfigData;
import org.testng.annotations.Test;

public class common_initconfig_test extends HsqInterfaceTest {

    private CommonInitconfigData model;

    @Test(description = "初始化配置")
    public void common_initconfig_true() {
        setUrl("common.initconfig.uri");
        process(true,false);
        model = sparseJson(CommonInitconfigData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("aboutUs", model.aboutUs);
        detailAssertTest("userAgreement", model.userAgreement);
        detailAssertTest("serviceTel", model.serviceTel);
        detailAssertTest("customerId", model.customerId);
        detailAssertTest("wholesaleEnabled", model.wholesaleEnabled);
        detailAssertTest("offline_log_url", model.offline_log_url);
        detailAssertTest("https_offline_log_url", model.https_offline_log_url);
        detailAssertTest("indexCartEnabled", String.valueOf(model.indexCartEnabled));
        detailAssertTest("userProtocol", model.userProtocol);
        detailAssertTest("cacheClear", model.cacheClear);
        detailAssertTest("udeskEnabled", model.udeskEnabled);
        detailAssertTest("cartNum", String.valueOf(model.cartNum));
        detailAssertTest("productionAreaOptions", model.productionAreaOptions);
        detailAssertTest("priceOptions", model.priceOptions);
        detailAssertTest("paymentway", model.paymentway);
        for (int i = 0; i < model.paymentway.size(); i++) {
            detailAssertTest("paymentway.get(i).id", model.paymentway.get(i).id);
            detailAssertTest("paymentway.get(i).name", model.paymentway.get(i).name);
            detailAssertTest("paymentway.get(i).icon", model.paymentway.get(i).icon);
        }
        detailAssertTest("customerName", model.customerName);
//        detailAssertTest("hotSearch.id", model.hotSearch.id);
//        detailAssertTest("hotSearch.value", model.hotSearch.value);
//        detailAssertTest("hotSearch.priority", String.valueOf(model.hotSearch.priority));
//        detailAssertTest("hotSearch.search_cnt", String.valueOf(model.hotSearch.search_cnt));
//        detailAssertTest("hotSearch.url", model.hotSearch.url);
//        detailAssertTest("hotSearch.type", model.hotSearch.type);
//        detailAssertTest("hotSearch.status", model.hotSearch.status);
//        detailAssertTest("hotSearch.channel", model.hotSearch.channel);
//        detailAssertTest("hotSearch.position", model.hotSearch.position);

        detailAssertTest("defaultLocation", String.valueOf(model.defaultLocation));
        detailAssertTest("defaultLocation.aMapId", model.defaultLocation.aMapId);
        detailAssertTest("defaultLocation.city", model.defaultLocation.city);
        detailAssertTest("defaultLocation.province", model.defaultLocation.province);
        detailAssertTest("defaultLocation.provinceId", model.defaultLocation.provinceId);
        detailAssertTest("defaultLocation.zoneId", model.defaultLocation.zoneId);
        detailAssertTest("defaultLocation.cityId", model.defaultLocation.cityId);
        detailAssertTest("is_write_log", model.is_write_log);
//        detailAssertTest("launchPic", model.launchPic);
//        for (int i = 0; i < model.launchPic.size(); i++) {
//            detailAssertTest("launchPic.get(i).img", model.launchPic.get(i).img);
//            detailAssertTest("launchPic.get(i).size", model.launchPic.get(i).size);
//            detailAssertTest("launchPic.get(i).type", model.launchPic.get(i).type);
//            detailAssertTest("launchPic.get(i).url", model.launchPic.get(i).url);
//            detailAssertTest("launchPic.get(i).link", model.launchPic.get(i).link);
//            detailAssertTest("launchPic.get(i).version", model.launchPic.get(i).version);
//            detailAssertTest("launchPic.get(i).highest_version", model.launchPic.get(i).highest_version);
//        }
        detailAssertTest("launchPicConfig", String.valueOf(model.launchPicConfig));
        detailAssertTest("launchPicConfig.noWifiDisplay", model.launchPicConfig.noWifiDisplay);
        detailAssertTest("launchPicConfig.displayTime", model.launchPicConfig.displayTime);
//        detailAssertTest("couponList", String.valueOf(model.couponList));
//        detailAssertTest("couponList.list", model.couponList.list);
//        for (int i = 0; i < model.couponList.list.size(); i++) {
//            detailAssertTest("couponList.list.get(i).title", model.couponList.list.get(i).title);
//            detailAssertTest("couponList.list.get(i).value", model.couponList.list.get(i).value);
//            detailAssertTest("couponList.list.get(i).schema", model.couponList.list.get(i).schema);
//            detailAssertTest("couponList.list.get(i).termOfValidity", model.couponList.list.get(i).termOfValidity);
//            detailAssertTest("couponList.list.get(i).range_type", model.couponList.list.get(i).range_type);
//        }
//        detailAssertTest("couponList.description", model.couponList.description);
//        detailAssertTest("couponList.popInterval", model.couponList.popInterval);

        detailAssertTest("dnsCheck", String.valueOf(model.dnsCheck));
        detailAssertTest("dnsCheck.isReport", model.dnsCheck.isReport);
        detailAssertTest("joinTaobaoConfig", model.joinTaobaoConfig);
        detailAssertTest("bannerWH", model.bannerWH);
        detailAssertTest("voiceSearch", model.voiceSearch);
        detailAssertTest("track", model.track);
//        detailAssertTest("user_flow", model.user_flow);
    }


}
