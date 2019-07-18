package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderLinkmallpointorderData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_linkmallpointorder_test extends HsqInterfaceTest {

    private OrderLinkmallpointorderData model;

    @Test(description = "入淘订单初始化")
    public void order_linkmallpointorder_true() {

        setUrl("order.linkmallpointorder.uri");
        List<NameValuePair> list = new LinkedList<>();

        //point_token 数据库该字段仅用于入淘订单初始化接口
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("point_token")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "pointAppId")));
        list.add(new BasicNameValuePair("pointId", SqlDetail.getInstance().getParamValue("pSkuId")));
        list.add(new BasicNameValuePair("type", "buy"));
        process(list, true, false);
        model = sparseJson(OrderLinkmallpointorderData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("link", model.link);
    }
}
