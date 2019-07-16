package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_titlebarmanage_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "标题栏管理")
    public void content_titlebarmanage_index_true() {

        setUrl("content.titlebarmanage.index.uri");
        process(false,false);

    }
}
