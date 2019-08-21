package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.fyb.CommonRecommendproductsData;
import org.testng.annotations.Test;


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


    }
}
