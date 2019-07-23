package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import org.testng.annotations.Test;

public class CommonZonelist extends JszInterfaceTest {

    @Test(description = "城市列表")
    public void commonZonelist() {
        setUrl("common.zonelist.uri");
        process(false, false);
    }
}
