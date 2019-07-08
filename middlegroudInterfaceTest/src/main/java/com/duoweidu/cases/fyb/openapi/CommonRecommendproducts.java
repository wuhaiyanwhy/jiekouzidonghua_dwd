package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;


public class CommonRecommendproducts extends FybInterfaceTest {

    @Test(description = "首页推荐列表")
    public void commonRecommendproducts() {
        setUrl("common.recommendproducts.uri");
        process(true,true);
    }
}
