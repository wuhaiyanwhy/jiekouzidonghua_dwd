package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.IqgConfig;
import com.duoweidu.utils.ConfigFileUrl;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class CouponorderPaymentresult extends IqgInterfaceTest {

    @Test(dependsOnGroups = "oneCouponOrderTrue",description = "一元券支付结果",groups = "oneCouponResult")
    public void couponorder_paymentresult_true() {
        setUrl("couponorder.paymentresult.uri");
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            try {
                JSONObject oneCouponOrderResult = new JSONObject(IqgConfig.oneCouponOrderResult);
                JSONObject oneCouponOrderData = (JSONObject) oneCouponOrderResult.get("data");
                param = "couponOrderId=" + oneCouponOrderData.get("order_id") + "&tradeNo=" + oneCouponOrderData.get("trade_no");
            }catch (JSONException e){
                GeneralAssert.jsonAssert(url, pathId, param, result, e);
            }
        }

        process(false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertStatus();
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONObject data = (JSONObject) jsonObject.get("data");
                JSONObject oneCouponReceivedId = (JSONObject) data.get("coup_user_received_info");
                //储存接口返回的订单id
                IqgConfig.oneCouponReceivedId = oneCouponReceivedId.get("id").toString();
                System.out.println(IqgConfig.oneCouponReceivedId);
            }catch (JSONException e){
                GeneralAssert.jsonAssert(url, pathId, param, result, e);
            }
        }
    }
}