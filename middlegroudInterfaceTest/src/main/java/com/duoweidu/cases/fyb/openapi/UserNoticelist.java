package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserNoticelist extends FybInterfaceTest {

    @Test(description = "系统消息列表")
    public void userNoticelist() {
        setUrl("user.noticelist.uri");
        param = "pageNum=1&pageLimit=10";
        process(true,true);
    }
}
