package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCreateorder extends JszInterfaceTest {

    @Test(groups = "OrderCreateorder",description = "下单")
    public void orderCreateorder() {
        setUrl("order.createorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", "10000"));
        process(list, true, false);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            int order_id = (int) data.get("order_id");
            int payment_id = (int) data.get("payment_id");
            JszConfig.order_id = String.valueOf(order_id);
            JszConfig.payment_id = String.valueOf(payment_id);
            System.out.println(JszConfig.order_id);
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }
}
