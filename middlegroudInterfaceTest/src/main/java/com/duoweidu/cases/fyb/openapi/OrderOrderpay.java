package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOrderpay extends FybInterfaceTest {

    @Test(dependsOnGroups = "orderSubmitorder",description = "订单支付",groups = "orderOrderpay")
    public void orderOrderpay() {
        setUrl("order.orderpay.uri");
        try {
            JSONObject jsonResult = new JSONObject(FybConfig.submitorderResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String orderIds = data.get("orderIds").toString();
            //截取字符串
            int start = orderIds.indexOf("[");
            int end = orderIds.lastIndexOf("]");
            String order = orderIds.substring(start + 1, end);
            System.out.println(order);
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderIds", order));
            list.add(new BasicNameValuePair("type", "3"));
            process(list, true, false);

            //orderpay接口的返回数据确定默认值
            FybConfig.orderpayResult = result;
        } catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }
}
