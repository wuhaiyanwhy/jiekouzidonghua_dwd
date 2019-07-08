package com.duoweidu.cases.fyb.openapi;


import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.GeneralAssert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancelorder extends FybInterfaceTest {

    @Test(dependsOnGroups = "orderOrderpayconfirm",description = "取消订单")
    public void OrderCancelorder() {
        setUrl("order.cancelorder.uri");
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
            list.add(new BasicNameValuePair("orderId", order));
            list.add(new BasicNameValuePair("reason", "1"));
            process(list,true,false);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }
}
