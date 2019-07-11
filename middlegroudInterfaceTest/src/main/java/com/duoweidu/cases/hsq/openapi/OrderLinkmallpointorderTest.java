package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderLinkmallpointorderTest extends HsqInterfaceTest {

    //未完成，积分流程需要重新调
    @Test(description = "下单跳转")
    public void orderLinkmallpointorderTrue() {
        setUrl("order.linkmallpointorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pointId", SqlDetail.getParamValue("pSkuId")));
        list.add(new BasicNameValuePair("amount", "1"));
        list.add(new BasicNameValuePair("type", "buy"));
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        list.add(new BasicNameValuePair("terminal", SqlDetail.getParamValue(0, "terminal")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getParamValue(0, "pointAppId")));
        process(list,true,false);
    }
}
