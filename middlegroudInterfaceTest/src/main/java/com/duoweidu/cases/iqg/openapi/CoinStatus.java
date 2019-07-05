package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class CoinStatus extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "领金币页")
    public void coin_status_true() {
        setUrl("coin.status.uri");
        process(true,false);
    }

}
