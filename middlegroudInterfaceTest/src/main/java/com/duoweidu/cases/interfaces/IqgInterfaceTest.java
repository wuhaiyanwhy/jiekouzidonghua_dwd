package com.duoweidu.cases.interfaces;

import com.duoweidu.config.GeneralAssert;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.IqgCallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class IqgInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getParamValue(0, "version")
                + "&lng=" + SqlDetail.getParamValue(0, "lng")
                + "lat=" +  SqlDetail.getParamValue(0, "lat");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = IqgCallbackInterface.getStringResult(url, pathId, this.param);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list, boolean isAssert, boolean isList) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("version", SqlDetail.getParamValue(0, "version")));
        list.add(new BasicNameValuePair("lng", SqlDetail.getParamValue(0, "lng")));
        list.add(new BasicNameValuePair("lat", SqlDetail.getParamValue(0, "lat")));
        param = list.toString();
        result = IqgCallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }


    //delete请求
    @Override
    protected void processDelete(boolean isAssert, boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getParamValue(0, "version")
                + "&lng=" + SqlDetail.getParamValue(0, "lng")
                + "lat=" +  SqlDetail.getParamValue(0, "lat");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = IqgCallbackInterface.deleteStringResult(url, pathId, this.param);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    //通用断言判断
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
}
