package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class OrderOderinitv1 extends HsqInterfaceTest {
    @Test(dependsOnGroups = "editsku" ,description = "普通订单初始化",groups = "oderinit")
    public void orderOderinitv1(){
        setUrl("order.orderinit_v1.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"skuId\":\""+ SqlDetail.getInstance().getParamValue("gonewskuId")
                + "\",\"amount\":\"1\",\"price\":\""+ SqlDetail.getInstance().getParamValue("goprice") + "\"}]"));
        process(list,true,false);
        try {
            //取临时订单ID
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            //存储临时订单
            HsqOpenapiConfig.goconfirmSid = data.get("confirmSid").toString();
        }catch (JSONException e) {
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }


    }
}
