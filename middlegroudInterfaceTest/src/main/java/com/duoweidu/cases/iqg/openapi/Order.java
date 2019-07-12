package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.IqgConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Order extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "提交订单",groups = "orderTrue")
    public void order_true() {
        //修改用户订单数据，使其可以下单
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            SqlDetail.iqgUptadeOrder();
        }
        url = ConfigFileUrl.getUrlByKey("order.uri");
        pathId = SqlDetail.getPathId("order.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("item_id", SqlDetail.getParamValue("buyActivityId")));
        list.add(new BasicNameValuePair("price",SqlDetail.getParamValue(2, "price")));
        process(list,false,false);
        IqgConfig.orderResult = result;
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            try {
                JSONObject jsonObject = new JSONObject(result);
                //拿到提交订单返回的orderid
                JSONObject data = (JSONObject) jsonObject.get("data");
                System.out.println(data);
                int id = (int) data.get("id");
                String ids = String.valueOf(id);
                IqgConfig.orderId = ids;
            }catch (JSONException e){
                GeneralAssert.jsonAssert(url, pathId, param, result, e);
            }
        }
    }
}
