package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class CoinExchangeList extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "金币列表")
    public void coin_exchange_list_true() {
        setUrl("coin.exchange_list.uri");
        process(false,false);
        generalAssertTest(false, true);
    }

}
