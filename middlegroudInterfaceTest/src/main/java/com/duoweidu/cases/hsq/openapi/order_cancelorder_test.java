package com.duoweidu.cases.hsq.openapi;
import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_cancelorder_test extends HsqInterfaceTest {

    private void genCancel(String orderResult, String reason) {
        setUrl("order.cancelorder.uri");
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
            list.add(new BasicNameValuePair("orderId", order));
            list.add(new BasicNameValuePair("reason", reason));
            process(list,true,false);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }

    }

    @Test(dependsOnGroups = "orderpayconfirmPutong",description = "取消订单(普通)")
    public void order_cancelorder_putongTrue() {
        genCancel(HsqOpenapiConfig.submitorderPutongResult, "1");
    }

    @Test(dependsOnGroups = "orderpayconfirmPintuan",description = "取消订单（拼团）")
    public void order_cancelorder_pintuanTrue() {
        genCancel(HsqOpenapiConfig.submitorderPintuanResult, "3");
    }


    @Test(dependsOnGroups = "orderpayconfirmDandugou",description = "取消订单（单独购）")
    public void order_cancelorder_dandugouTrue() {
        genCancel(HsqOpenapiConfig.submitorderDandugouResult, "4");
    }


}
