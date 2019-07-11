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

public class user_unlikemerchant_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "取消收藏店铺")
    public void user_unlikemerchant_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_UNLIKEMERCHANT);
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("merchantIdsJson","[   {     \"merchantId\" : "
                + SqlDetail.getParamValue("merchantId") +",     \"sourceType\" : 1   } ]");
        list.add(param1);
        process(list,true,false);
    }

}
