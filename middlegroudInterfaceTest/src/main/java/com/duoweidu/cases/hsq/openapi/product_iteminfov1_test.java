package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.testng.annotations.Test;

public class product_iteminfov1_test extends HsqInterfaceTest {
    @Test(dependsOnGroups = "loginTrue",description="购物车商品详情页")
    public void product_iteminfov1_true(){
          setUrl("product.iteminfov1.uri");
          param = "skuIds=" + SqlDetail.getInstance().getParamValue("skuIds");
          process(true,false);
    }

}
