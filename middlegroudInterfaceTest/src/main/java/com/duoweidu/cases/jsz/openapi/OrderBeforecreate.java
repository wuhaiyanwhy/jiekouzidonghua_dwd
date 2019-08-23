package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.OrderBeforecreateData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Delayed;

public class OrderBeforecreate extends JszInterfaceTest {

    private OrderBeforecreateData model;

    @Test(description = "提交订单")
    public void orderBeforecreate() {
        setUrl("order.beforecreate.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue("activityId")));
        process(list,true, false);
        model = sparseJson(OrderBeforecreateData.class);
        detailAssert();
    }

    private void detailAssert(){
        detailAssertTest("activity_id",model.activity_id);
        detailAssertTest("left_stock",model.left_stock);
        detailAssertTest("commission_price",model.commission_price);
        detailAssertTest("item_name",model.item_name);
        detailAssertTest("market_price",model.market_price);
        detailAssertTest("sale_price",model.sale_price);
        detailAssertTest("item_image",model.item_image);
        for( int i = 0; i<model.special_tips.size(); i++){
            detailAssertTest("icon",model.special_tips.get(i).icon);
            detailAssertTest("key",model.special_tips.get(i).key);
            detailAssertTest("text",model.special_tips.get(i).text);
        }
        detailAssertTest("tips",model.tips);
        detailAssertTest("redeem_time",model.redeem_time);
        for( int i = 0;i<model.tips_array.size(); i++){
            detailAssertTest("title",model.tips_array.get(i).title);
            detailAssertTest("text",model.tips_array.get(i).text);
        }
        detailAssertTest("pay_amount",model.pay_amount);
    }
}

