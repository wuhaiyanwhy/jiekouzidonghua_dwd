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

public class user_likeproductfromcart_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "移入收藏")
    public void user_likeproductfromcart_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_LIKEPRODUCTFROMCART);
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("skusInfo",
                "[\n" +
                        "  {\n" +
                        "    \"skuId\" : " + SqlDetail.getParamValue("skuId") + ",\n" +
                        "    \"amount\" : \"1\"\n" +
                        "  }\n" +
                        "]");
        list.add(param1);
        process(list,true,false);
    }

}
