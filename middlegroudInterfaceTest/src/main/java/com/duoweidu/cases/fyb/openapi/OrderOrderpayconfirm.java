package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.GeneralAssert;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class OrderOrderpayconfirm extends FybInterfaceTest {

    @Test(dependsOnGroups = "orderOrderpay",description = "确认支付状态(普通)",groups = "orderOrderpayconfirm")
    public void orderOrderpayconfirm() {
        setUrl("order.orderpayconfirm.uri");
        try {
            JSONObject jsonResult = new JSONObject(FybConfig.orderpayResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String mergeType = data.get("mergeType").toString();
            String paymentId = data.get("paymentId").toString();
            param = "mergeType="+mergeType+"&"+"paymentId="+paymentId;
            process(false,false);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param,result,e);
        }
    }
}
