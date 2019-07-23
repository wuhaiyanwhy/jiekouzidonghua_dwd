package com.duoweidu.cases.msf.opadmin;

import com.duoweidu.cases.interfaces.MsfOpadminInterfaceTest;
import org.testng.annotations.Test;

public class AdminMerchantList extends MsfOpadminInterfaceTest {

    @Test(description = "商户列表")
    public void merchantList() {
        setUrl("admin.merchant.list.uri");
        param = "timestamp=1563849773993&need_pagination=1&page_limit=10&page_num=1";
        process();
    }
}
