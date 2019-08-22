package com.duoweidu.cases.jsz.openapi;

import com.duoweidu.cases.interfaces.JszInterfaceTest;
import com.duoweidu.config.JszConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.jsz.OrderCreateorderData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderCreateorder extends JszInterfaceTest {

    private OrderCreateorderData model;

    @Test(groups = "OrderCreateorder",description = "下单")
    public void orderCreateorder() {
        setUrl("order.createorder.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue("activityId")));
        process(list, false, false);
        model = sparseJson(OrderCreateorderData.class);
        detailAssert();
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
        }


        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            int order_id = (int) data.get("order_id");
            int payment_id = (int) data.get("payment_id");
            JszConfig.order_id = String.valueOf(order_id);
            JszConfig.payment_id = String.valueOf(payment_id);
            System.out.println(JszConfig.order_id);
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    private void detailAssert(){
        detailAssertTest("",model.order_id);
        detailAssertTest("",model.payment_id);
        for( int i = 0; i<model.sign_data.size(); i++){
            detailAssertTest("",model.sign_data.get(i).appId);
            detailAssertTest("",model.sign_data.get(i).timeStamp);
            detailAssertTest("",model.sign_data.get(i).nonceStr);
//            detailAssertTest("",model.sign_data.get(i).package);
            detailAssertTest("",model.sign_data.get(i).signType);
            detailAssertTest("",model.sign_data.get(i).paySign);
        }
    }
}
