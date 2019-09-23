package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.OrderSubmitorderv1Data;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderSubmitorderv1 extends HsqInterfaceTest {

    private OrderSubmitorderv1Data model;

    private void getRequest(List<NameValuePair> list) {
        setUrl("order.submitorder_v1.uri");
        process(list,true,false) ;
        model = sparseJson(OrderSubmitorderv1Data.class);
        detailassert();
    }

    @Test(dependsOnGroups = "oderinit",description = "提交普通订单" ,groups = "submitOrder")
    public void orderSubmitorderv1(){
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type",SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("confirmOrderSerialId", HsqOpenapiConfig.goconfirmSid ));
        list.add(new BasicNameValuePair("addressId", SqlDetail.getInstance().getParamValue("goaddressId")));
        getRequest(list);
        JSONObject jsonresult = new JSONObject(result);
        JSONObject  data = (JSONObject) jsonresult.get("data");
        String orderIds = data.get("orderIds").toString();
        int start = orderIds.indexOf("[");
        int end=orderIds.lastIndexOf("]");
        HsqOpenapiConfig.orderIds= orderIds.substring(start+1, end);
    }

    @Test(dependsOnGroups = "oderinitMerchant",description = "提交普通订单（只有商家优惠，2件）" ,groups = "submitOrderMerchant")
    public void orderSubmitorderv1Merchant(){
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("Content-Type", SqlDetail.getInstance().getParamValue(0, "Content-Type")));
            list.add(new BasicNameValuePair("confirmOrderSerialId", HsqOpenapiConfig.merchantConfirmSid));
            list.add(new BasicNameValuePair("addressId", SqlDetail.getInstance().getParamValue("addressId")));
            getRequest(list);
        }else {
            System.out.println("此环境无此case");
        }
    }

    private void detailassert() {
        assertNotEmpty("orderIds", model.orderIds);
        assertTrue("needPay", model.needPay);
    }
}
