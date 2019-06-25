package com.duoweidu.cases.interfaces;

import com.alibaba.fastjson.JSON;
import com.duoweidu.config.GeneralAssert;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest {


    //用来储存url
    protected String url;
    //用来储存接口路径
    protected String path;
    //用来储存参数信息
    protected String param;
    //用来储存返回的结果
    protected String result;
    //储存报错结果
    protected String faile;

    {
        faile = GeneralAssert.distinguishParamFailed(faile, param, result, result, 1);
    }

    protected <T> T sparseJson(Class<T> clazz) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = jsonObject.getJSONObject("data");
            return JSON.parseObject(data.toString(), clazz);
        } catch (JSONException e) {
            GeneralAssert.jsonAssert(url, param, result, e);
        }
        return null;
    }

    //get请求
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "v=" + TestSql.getOpenapiValue("v",4);
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = CallbackInterface.getStringResult(url,this.param);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
        Assert.assertEquals(1,2 ,faile);
    }

    //post请求
    protected void process(List<NameValuePair> list, boolean isAssert, boolean isList) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("v",TestSql.getOpenapiValue("v",4)));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    //通用断言判断，只判断errno
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, param, result);
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url,param,result,e);
        }
    }

    //通用断言判断
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            GeneralAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, param, result);
            GeneralAssert.dataAssert(jsonObject.get("data").toString(), url, param, result);
            if (isList == true) {
                GeneralAssert.listAssert((JSONArray) data.get("list"), url, param, result);
            }
        }catch (JSONException e){
            GeneralAssert.jsonAssert(url,param,result,e);
        }
    }


}
