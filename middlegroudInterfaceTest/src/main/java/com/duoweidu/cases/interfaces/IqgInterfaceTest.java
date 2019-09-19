package com.duoweidu.cases.interfaces;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.IqgCallbackInterface;
import com.duoweidu.utils.Uuid;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class IqgInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid()
                + "&version=" + SqlDetail.getInstance().getParamValue(0, "version")
                + "&lng=" + SqlDetail.getInstance().getParamValue(0, "lng")
                + "&lat=" +  SqlDetail.getInstance().getParamValue(0, "lat");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = IqgCallbackInterface.getStringResult(limitTime(), url, pathId, this.param);
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("interface_uuid", Uuid.getUuid()));
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("lng", SqlDetail.getInstance().getParamValue(0, "lng")));
        list.add(new BasicNameValuePair("lat", SqlDetail.getInstance().getParamValue(0, "lat")));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = IqgCallbackInterface.postStringResult(limitTime(), url, pathId, list);
    }


    //delete请求
    @Override
    protected void processDelete() {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid()
                + "&version=" + SqlDetail.getInstance().getParamValue(0, "version")
                + "&lng=" + SqlDetail.getInstance().getParamValue(0, "lng")
                + "&lat=" +  SqlDetail.getInstance().getParamValue(0, "lat");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = IqgCallbackInterface.deleteStringResult(limitTime(), url, pathId, this.param);
    }

    //通用断言判断

    @Override
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssert.statusTest((JSONObject) jsonObject.get("status"), url, pathId, param, result);
            GeneralAssert.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    @Override
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            GeneralAssert.statusTest((JSONObject) jsonObject.get("status"), url, pathId, param, result);
            GeneralAssert.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
            if (isList == true) {
                GeneralAssert.listAssert((JSONArray) data.get("list"), url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isDataList, boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (isDataList == true) {
                JSONArray data = (JSONArray) jsonObject.get("data");
                GeneralAssert.statusTest((JSONObject) jsonObject.get("status"), url, pathId, param, result);
                GeneralAssert.dataAssert(data, url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject json = (JSONObject) data.get(i);
                        GeneralAssert.listAssert((JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }


    //只判断status
    protected void generalAssertStatus() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssert.statusTest((JSONObject) jsonObject.get("status"), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url, pathId, param, result, e);
        }
    }


}
