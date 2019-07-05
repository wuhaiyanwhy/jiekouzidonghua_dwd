package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CoinCheckIn extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取金币")
    public void coin_check_in_true() {
        setUrl("coin.check_in.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
    }
}
