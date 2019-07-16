package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.testng.annotations.Test;


public class content_hotsearchsug_index_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "搜索热词")
    public void content_hotsearchsug_index_true() {
        setUrl("content.hotsearchsug.index.uri");
        process(false,false);

    }

}
