package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.testng.annotations.Test;

public class point_index_test extends HsqInterfaceTest {

    @Test(description ="积分首页")
    public void point_index_true() {
        setUrl("point.index.uri");
        param = "channel=h5&pointChannelId=1";
        process(true,false);

    }
}
