package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.model.fyb.CommonRecommendproductsData;
import org.testng.annotations.Test;

import java.util.Map;


public class CommonRecommendproducts extends FybInterfaceTest {

    private CommonRecommendproductsData model;

    @Test(description = "首页推荐列表")
    public void commonRecommendproducts() {
        setUrl("common.recommendproducts.uri");
        process(true,true);
        model = sparseJson(CommonRecommendproductsData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapList = TraverseConfig.traverseCollection(model.list);
        Map<String, Object> mapHasReturnList = TraverseConfig.traverseCollection(model.hasReturnList);
        Map<String, Object> mapBannerList = TraverseConfig.traverseCollection(model.bannerList);
        Map<String, Object> mapTopNavigateList = TraverseConfig.traverseCollection(model.topNavigateList);
        Map<String, Object> mapIcon = TraverseConfig.traverseCollection(model.icon);
        Map<String, Object> mapTodayHot = TraverseConfig.traverseCollection(model.todayHot);
        Map<String, Object> mapAdvertisement = TraverseConfig.traverseCollection(model.advertisement);
        for (Map.Entry<String, Object> entry:
                mapList.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
            assertNotEmpty(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapHasReturnList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapBannerList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapTopNavigateList.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapIcon.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapTodayHot.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> entry:
                mapAdvertisement.entrySet()) {
            assertNotNull(entry.getKey(), entry.getValue());
        }


    }
}
