package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_advertisemanage_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "广告位管理")
    public void content_advertisemanage_index_true() {

        setUrl("content.advertisemanage.index.uri");
        process(false,false);

    }

}
