package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class stock_stock_jointaobao_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "淘宝商品绑定管理")
    public void stock_stock_jointaobao_true() {
        setUrl("stock.stock.jointaobao.uri");
        process(false,false);

    }
}
