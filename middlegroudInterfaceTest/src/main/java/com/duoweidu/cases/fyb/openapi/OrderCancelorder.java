package com.duoweidu.cases.fyb.openapi;


import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.model.fyb.OrderCancelorderData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCancelorder extends FybInterfaceTest {

    private OrderCancelorderData model;

    @Test(dependsOnGroups = "orderOrderpayconfirm",description = "取消订单")
    public void OrderCancelorder() {
        setUrl("order.cancelorder.uri");
        try {
            JSONObject jsonResult = new JSONObject(FybConfig.submitorderResult);
            JSONObject data = (JSONObject) jsonResult.get("data");
            String orderIds = data.get("orderIds").toString();
            //截取字符串
            int start = orderIds.indexOf("[");
            int end = orderIds.lastIndexOf("]");
            String order = orderIds.substring(start + 1, end);
            System.out.println(order);
            List<NameValuePair> list = new LinkedList<>();
            list.add(new BasicNameValuePair("orderId", order));
            list.add(new BasicNameValuePair("reason", "1"));
            process(list,true,false);
            model = sparseJson(OrderCancelorderData.class);
            detailAssert();
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    private void detailAssert() {
        assertNotEmpty("id", model.id);
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("merchant_id", model.merchant_id);
        assertNotEmpty("status", model.status);
        assertNotEmpty("delivery_way", model.delivery_way);
        assertNotEmpty("delivery_status", model.delivery_status);
        assertNotEmpty("comment_status", model.comment_status);
        assertNotEmpty("id", model.market_price);
        assertNotEmpty("market_price", model.id);
        assertNotEmpty("need_pay_price", model.need_pay_price);
        assertNotEmpty("total_price", model.total_price);
        assertNotEmpty("total_amount", model.total_amount);
        assertNotEmpty("address_id", model.address_id);
        assertNotEmpty("delivery_type", model.delivery_type);
        assertNotEmpty("delivery_fee_way", model.delivery_fee_way);
        assertNotEmpty("is_delivery_free", model.is_delivery_free);
        assertNotEmpty("delivery_province", model.delivery_province);
        assertNotEmpty("invoice_type", model.invoice_type);
        assertNotEmpty("delivery_city", model.delivery_city);
        assertNotEmpty("delivery_district", model.delivery_district);
        assertNotEmpty("delivery_detail_address", model.delivery_detail_address);
        assertNotEmpty("consignee", model.consignee);
        assertNotEmpty("consignee_phone", model.consignee_phone);
        assertNotEmpty("created_at", model.created_at);
        assertNotEmpty("updated_at", model.updated_at);
        assertNotEmpty("order_type", model.order_type);
        assertNotEmpty("source_type", model.source_type);
        assertNotEmpty("canCancel", model.canCancel);
        assertNotEmpty("canRefund", model.canRefund);
        assertNotEmpty("statusCode", model.statusCode);



    }
}
