package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.testng.annotations.Test;

public class UserVoucherlist extends FybInterfaceTest {

    @Test(description = "用户代金券列表")
    public void userVoucherlist() {
        setUrl("user.voucherlist.uri");
        param = "needPagination=1&pageNum=1&pageLimit=10";
        process(true,true);
    }
}
