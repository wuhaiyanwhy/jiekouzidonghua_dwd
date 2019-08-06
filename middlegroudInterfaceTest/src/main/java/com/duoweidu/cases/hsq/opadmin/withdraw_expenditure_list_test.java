package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class withdraw_expenditure_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "商户支出明细列表")
    public void withdraw_expenditure_list_true() {

        setUrl("withdraw.expenditure.list.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("createStartTime","2019-01-01"));
        list.add(new BasicNameValuePair("createEndTime","2019-01-15"));
        list.add(new BasicNameValuePair("updateStartTime","null"));
        list.add(new BasicNameValuePair("updateEndTime","null"));
        list.add(new BasicNameValuePair("endStatus","0"));
        list.add(new BasicNameValuePair("type","0"));

        process(list);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray listJson = (JSONArray) jsonObject.get("list");
            GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), listJson, url, pathId, param, result);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }

    }

}
