package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

/**
 * 此接口可能禁用，暂时无需详细断言
 */
public class ProductRiskbannerTest extends HsqInterfaceTest {

//    private ProductRiskbannerData model;

    @Test(description = "获取riskgobanner")
    public void productRiskbannerTrue() {
        setUrl("product.riskbanner.uri");
        param = "riskRank=rank1";
        process(true, false);
//        model = sparseJson(ProductRiskbannerData.class);
//        detailAssert();
    }
//    private void detailAssert() {
//        assertNotEmpty("link",model.link);
//        assertNotEmpty("banner",model.banner);
//        assertNotEmpty("rank",model.rank);
//    }
}
