package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_getdealerlicense_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取门店资质信息")
    public void user_getdealerlicense_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_GETDEALERLICENSE);
        List<NameValuePair> list = new LinkedList<>();
//        BasicNameValuePair param1 = new BasicNameValuePair("merchantId","102");
//        list.add(param1);
        process(list,false,false);
    }
}
