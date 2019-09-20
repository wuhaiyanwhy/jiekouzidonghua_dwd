package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
public class OrderSubmitorderv1 extends HsqInterfaceTest {
    @Test(dependsOnGroups = "oderinit",description = "提交普通订单" ,groups = "submitOrder")
    public void orderSubmitorderv1(){
        setUrl("order.submitorder_v1.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type",SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("confirmOrderSerialId", HsqOpenapiConfig.goconfirmSid ));
        list.add(new BasicNameValuePair("addressId", SqlDetail.getInstance().getParamValue("goaddressId")));
        process(list,true,false) ;
        JSONObject jsonresult = new JSONObject(result);
        JSONObject  data = (JSONObject) jsonresult.get("data");
        String orderIds = data.get("orderIds").toString();
        int start = orderIds.indexOf("[");
        int end=orderIds.lastIndexOf("]");
        HsqOpenapiConfig.orderIds= orderIds.substring(start+1, end);
    }
}
