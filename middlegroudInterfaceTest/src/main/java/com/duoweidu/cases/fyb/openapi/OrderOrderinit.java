package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOrderinit extends FybInterfaceTest {

    @Test(description = "订单初始化",groups = "orderOrderinit")
    public void orderOrderinit() {
        setUrl("order.orderinit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":"+ SqlDetail.getParamValue("skuId") +
                ",\"amount\":1,\"price\":" + SqlDetail.getParamValue("price") + "}]"));
        process(list,true,false);
        FybConfig.orderinitResult = result;

    }
}
