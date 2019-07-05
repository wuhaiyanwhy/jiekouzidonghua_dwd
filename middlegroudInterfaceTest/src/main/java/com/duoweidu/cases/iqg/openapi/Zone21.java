package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Zone21 extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "选择城市")
    public void ZoneTrue() {
        setUrl("zone.21.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,false,false);
        generalAssertStatus();
    }
}
