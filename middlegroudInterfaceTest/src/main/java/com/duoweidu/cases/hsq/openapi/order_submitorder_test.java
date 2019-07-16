package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderSubmitorderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_submitorder_test extends HsqInterfaceTest {

    private OrderSubmitorderData model;

    private void submitorderConfig(List<NameValuePair> list, String orderinitResult) {
        setUrl("order.submitorder.uri");
        try {
            JSONObject jsonResult = new JSONObject(orderinitResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            JSONObject address = (JSONObject) data.get("address");
            String confirmSid = (String) data.get("confirmSid");
            String id = address.get("id").toString();

            list.add(new BasicNameValuePair("confirmOrderSerialId", confirmSid));
            list.add(new BasicNameValuePair("addressId", id));
            list.add(new BasicNameValuePair("invoice", "{\"type\":1}"));
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
        process(list,true,false);
        model = sparseJson(OrderSubmitorderData.class);
        generalDetailAssert();

    }


    @Test(dependsOnGroups = "orderinitPutong",description = "提交订单（普通）",groups = "submitorderPutong")
    public void order_submitorder_putongTrue() {
        List<NameValuePair> list = new LinkedList<>();
        submitorderConfig(list, HsqOpenapiConfig.orderinitResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderPutongResult = result;
    }

    @Test(dependsOnGroups = "orderinitPintuan",description = "提交订单（拼团）",groups = "submitorderPintuan")
    public void order_submitorder_pintuanTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType","3"));
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitPintuanResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderPintuanResult = result;
    }


    @Test(dependsOnGroups = "orderinitDandugou",description = "提交订单（单独购）(用券)",groups = "submitorderDandugou")
    public void order_submitorder_dandugouTrue() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("orderType", "2"));
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("couponId", String.valueOf(HsqOpenapiConfig.couponId)));
            list.add(new BasicNameValuePair("couponCode", HsqOpenapiConfig.couponCode));
        }
        submitorderConfig(list, HsqOpenapiConfig.coupleorderinitDandugouResult);
        //submitorder普通订单接口的返回数据确定默认值
        HsqOpenapiConfig.submitorderDandugouResult = result;
    }

    @Test(dependsOnGroups = "orderinitActivitePintuan",description = "提交订单（拼团）(活动报名)",groups = "submitorderActivitePintuan")
    public void order_submitorder_activitrPintuanTrue() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitiePintuanResult);
        }

    }

    @Test(dependsOnGroups = "orderinitLosePintuan2",description = "提交订单（拼团）(多件优惠减钱)",groups = "submitorderLosePintuan2")
    public void order_submitorder_losePintuanTrue2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitLosePintuanResult2);
        }

    }

    @Test(dependsOnGroups = "orderinitActivitePayPintuan5",description = "提交订单（拼团）(活动报名+多件优惠付钱)",groups = "submitorderActivitePayPintuan5")
    public void order_submitorder_activitePayPintuan2() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "3"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActivitePayResult5);
        }

    }

    @Test(dependsOnGroups = "orderinitActivitePayPintuan5",description = "提交订单（单独购）(活动报名+多件优惠打折)",groups = "submitorderActiviteDiscountDandugou4")
    public void order_submitorder_activiteDiscountDandugou4() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "2"));
            submitorderConfig(list, HsqOpenapiConfig.coupleorderinitActiviteDiscountDandugouResult4);
        }

    }

    @Test(dependsOnGroups = "orderinitXinyonggou", description = "提交订单（信用购）",groups = "submitorderXinyonggou")
    public void order_submitorder_xinyong() {
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderType", "11"));
            list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
            submitorderConfig(list, HsqOpenapiConfig.orderInitResult);
        }

    }

    public void generalDetailAssert() {
        detailAssertTest(1, "model.needPay", model.orderIds.size());
        detailAssertTest(true, "model.needPay", model.needPay);
    }


}
