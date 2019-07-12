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

public class OrderSubmitorder extends FybInterfaceTest {

    @Test(dependsOnGroups = "orderOrderinit",description = "提交订单",groups = "orderSubmitorder")
    public void orderSubmitorder() {
        setUrl("order.submitorder.uri");
        try {
            JSONObject jsonResult = new JSONObject(FybConfig.orderinitResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            JSONObject address = (JSONObject) data.get("address");
            String confirmSid = (String) data.get("confirmSid");
            String id = address.get("id").toString();

            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("confirmOrderSerialId", confirmSid));
            list.add(new BasicNameValuePair("addressId", id));
            list.add(new BasicNameValuePair("invoice", "{\"type\":1}"));
            list.add(new BasicNameValuePair("notes", "{}"));
            list.add(new BasicNameValuePair("useVoucherMoney", "1"));

            process(list,true,false);
            //submitorder普通订单接口的返回数据确定默认值
            FybConfig.submitorderResult = result;
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }

    }
}
