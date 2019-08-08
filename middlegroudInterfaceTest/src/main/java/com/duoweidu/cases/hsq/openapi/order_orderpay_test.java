package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.model.hsq.OrderOrderpayData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_orderpay_test extends HsqInterfaceTest {

    private OrderOrderpayData model;

    private  void  genOrderpay(String orderResult, String type) {
        setUrl("order.orderpay.uri");
        try {
            JSONObject jsonResult = new JSONObject(orderResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String orderIds = data.get("orderIds").toString();
            //截取字符串
            int start = orderIds.indexOf("[");
            int end = orderIds.lastIndexOf("]");
            String order = orderIds.substring(start + 1, end);
            System.out.println(order);
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderIds", order));
            list.add(new BasicNameValuePair("type", type));
            process(list,true,false);
            model = sparseJson(OrderOrderpayData.class);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    @Test(dependsOnGroups = "submitorderPutong",description = "提交支付(普通)",groups = "orderpayPutong")
    public void order_orderpay_putongTrue() {
        genOrderpay(HsqOpenapiConfig.submitorderPutongResult, "3");
        //orderpay普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.orderpayPutongResult = result;
        putongDetailAssert();

    }

    @Test(dependsOnGroups = "submitorderPintuan",description = "提交支付（拼团）",groups = "orderpayPintuan")
    public void order_orderpay_pintuanTrue() {
        genOrderpay(HsqOpenapiConfig.submitorderPintuanResult, "1");
        //orderpay普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.orderpayPintuanResult = result;
        pintuanDetailAssert();

    }


    @Test(dependsOnGroups = "submitorderDandugou",description = "提交订单（单独购）",groups = "orderpayDandugou")
    public void order_orderpay_dandugouTrue() {
        genOrderpay(HsqOpenapiConfig.submitorderDandugouResult, "3");
        //orderpay普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.orderpayDandugouResult = result;
    }

    private void putongDetailAssert() {
        detailAssertTest("partner", model.partner);
        detailAssertTest("seller", model.seller);
        detailAssertTest("paymentStr", model.paymentStr);
        detailAssertTest("mergeType", model.mergeType);
        detailAssertTest("paymentId", model.paymentId);
    }

    private void pintuanDetailAssert() {
        detailAssertTest("appid", model.appid);
        detailAssertTest("noncestr", model.noncestr);
        detailAssertTest("package", model.page);
        detailAssertTest("partnerid", model.partnerid);
        detailAssertTest("prepayid", model.prepayid);
        detailAssertTest("timestamp", model.timestamp);
        detailAssertTest("paysign", model.paysign);

        detailAssertTest("mergeType", model.mergeType);
        detailAssertTest("paymentId", model.paymentId);
    }
}
