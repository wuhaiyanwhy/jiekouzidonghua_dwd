package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class CommonHotsearchsug extends FybInterfaceTest {

    @Test(description = "商品推荐词")
    public void commonHotsearchsug() {
        setUrl("common.hotsearchsug.uri");
        process(true,false);
    }
}
