package com.duoweidu.cases.hsq.openapi;
import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.model.hsq.OrderCancelorderData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class order_cancelorder_test extends HsqInterfaceTest {

    private OrderCancelorderData model;

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
            model = sparseJson(OrderCancelorderData.class);
            detailAssert();
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

    private void detailAssert() {
        detailAssertTest("id", model.id);
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("merchant_id", model.merchant_id);
        detailAssertTest("交易关闭", "status", model.status);
        detailAssertTest("delivery_way", model.delivery_way);
        detailAssertTest("delivery_status", model.delivery_status);
        detailAssertTest("comment_status", model.comment_status);
        detailAssertTest("merchant_discount", String.valueOf(model.merchant_discount));
        detailAssertTest("platform_discount", String.valueOf(model.platform_discount));
        detailAssertTest("market_price", model.market_price);
        detailAssertTest("pay_price", String.valueOf(model.pay_price));
        detailAssertTest("pay_id", String.valueOf(model.pay_id));
        detailAssertTest("need_pay_price", model.need_pay_price);
        detailAssertTest("discount_price", String.valueOf(model.discount_price));
        detailAssertTest("delivery_price", String.valueOf(model.delivery_price));
        detailAssertTest("total_price", model.total_price);
        detailAssertTest("total_amount", model.total_amount);
//        detailAssertTest("pay_time", model.pay_time);
//        detailAssertTest("delivery_time", model.delivery_time);
        detailAssertTest(0, "confirm_time", model.confirm_time);
        detailAssertTest("address_id", model.address_id);
        detailAssertTest("delivery_type", model.delivery_type);
        detailAssertTest("delivery_fee_way", model.delivery_fee_way);
        detailAssertTest("is_delivery_free", model.is_delivery_free);
//        detailAssertTest("note", model.note);
        detailAssertTest("delivery_province", model.delivery_province);
        detailAssertTest("invoice_type", model.invoice_type);
//        detailAssertTest("invoice_title", model.invoice_title);
        detailAssertTest("delivery_city", model.delivery_city);
        detailAssertTest("delivery_district", model.delivery_district);
        detailAssertTest("delivery_detail_address", model.delivery_detail_address);
        detailAssertTest("consignee", model.consignee);
        detailAssertTest("consignee_phone", model.consignee_phone);
        detailAssertTest("created_at", model.created_at);
        detailAssertTest("updated_at", model.updated_at);
        detailAssertTest("order_type", model.order_type);
//        detailAssertTest("pin_activities_id", model.pin_activities_id);
//        detailAssertTest(null, "pin_event_id", model.pin_event_id);
        detailAssertTest("source_type", model.source_type);
//        detailAssertTest(0, "point_payment_id", model.point_payment_id);
//        detailAssertTest(0, "payways", model.payways);
//        detailAssertTest("", "pay_info", model.pay_info);
        detailAssertTest(false, "canCancel", model.canCancel);
        detailAssertTest(false, "canRefund", model.canRefund);
        detailAssertTest("statusCode", model.statusCode);


    }


}
