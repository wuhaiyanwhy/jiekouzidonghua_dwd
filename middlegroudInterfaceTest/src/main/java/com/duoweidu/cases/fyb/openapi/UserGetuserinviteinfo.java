package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserGetuserinviteinfo extends FybInterfaceTest {

    @Test(description = "赚红包")
    public void userGetuserinviteinfo() {
        setUrl("user.getuserinviteinfo.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,false);
    }
}
