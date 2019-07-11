package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_likemerchant_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "收藏店铺")
    public void user_likemerchant_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_LIKEMERCHANT);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("merchantId", SqlDetail.getParamValue("merchantId")));
        process(list,true,false);
    }
}
