package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.IqgConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class CouponorderPaymentapply extends IqgInterfaceTest {


    @Test(dependsOnGroups = "loginTrue",description = "一元券支付",groups = "oneCouponOrderTrue")
    public void couponorder_paymentapply_true() {
        setUrl("couponorder.paymentapply.uri");
        param = "branchId=" + SqlDetail.getInstance().getParamValue("branchId") +
                "&coupActivityId=" + SqlDetail.getInstance().getParamValue(2, "oneCouponID") +
                "&couponOrderId=0&paymentChannelId=3&platform2=ios&zone_id" + SqlDetail.getInstance().getParamValue(0, "zone_id");
        process(false,false);
        try {
            if ("beta".equals(ConfigFileUrl.getEnv())) {
                generalAssertTest(false);
                JSONObject jsonObject = new JSONObject(result);
                JSONObject data = (JSONObject) jsonObject.get("data");
                //储存接口返回信息
                IqgConfig.oneCouponOrderResult = result;
                //储存接口返回的订单id
                IqgConfig.oneCouponOrderId = data.get("order_id").toString();
                System.out.println(IqgConfig.oneCouponOrderId);
            }
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }

    }
}
