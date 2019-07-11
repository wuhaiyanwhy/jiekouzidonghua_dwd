package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.HsqOpenapiConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class order_orderpayconfirm_test extends HsqInterfaceTest {

    private void genOrderpayconfirm(String orderPayResult) {
        setUrl("order.orderpayconfirm.uri");
        try {
            JSONObject jsonResult = new JSONObject(orderPayResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String mergeType = data.get("mergeType").toString();
            String paymentId = data.get("paymentId").toString();
            param = "mergeType="+mergeType+"&"+"paymentId="+paymentId;
            process(false,false);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    @Test(dependsOnGroups = "orderpayPutong",description = "确认支付状态(普通)",groups = "orderpayconfirmPutong")
    public void order_orderpayconfirm_putongTrue() {
        genOrderpayconfirm(HsqOpenapiConfig.orderpayPutongResult);
    }

    @Test(dependsOnGroups = "orderpayPintuan",description = "确认支付状态（拼团）",groups = "orderpayconfirmPintuan")
    public void order_orderpayconfirm_pintuanTrue() {
        genOrderpayconfirm(HsqOpenapiConfig.orderpayPintuanResult);
    }


    @Test(dependsOnGroups = "orderpayDandugou",description = "确认支付状态（单独购）",groups = "orderpayconfirmDandugou")
    public void order_orderpayconfirm_dandugouTrue() throws IOException {
        genOrderpayconfirm(HsqOpenapiConfig.orderpayDandugouResult);
    }

}
