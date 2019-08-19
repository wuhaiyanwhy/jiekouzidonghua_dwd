package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.model.hsq.ProductRiskbannerData;
import org.testng.annotations.Test;

public class ProductRiskbannerTest extends HsqInterfaceTest {

    private ProductRiskbannerData model;

    @Test(description = "获取riskgobanner")
    public void productRiskbannerTrue() {
        setUrl("product.riskbanner.uri");
        param = "riskRank=rank1";
        process(true, false);
        model = sparseJson(ProductRiskbannerData.class);
//        detailAssert();
    }
//    private void detailAssert() {
//        assertEmpty("link",model.link);
//        assertEmpty("banner",model.banner);
//        assertEmpty("rank",model.rank);
//    }
}
