package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.testng.annotations.Test;

public class AddressInfo extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "今日砍价用户头像")
    public void addressInfoTrue() {
        setUrl("address.info.uri");
        param = "zone_id=21";
        process(true,false);
    }

}
