package com.duoweidu.cases.interfaces;

import com.alibaba.fastjson.JSON;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.CallbackInterfaceChannel;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest {


    //用来储存url
    protected String url;
    //用来储存接口路径id
    protected int pathId;
    //用来储存参数信息
    protected String param;
    //用来储存返回的结果
    protected String result;

    /**
     * 获取渠道id
     */
    public int channel_id() {
        return ConfigFileUrl.getChannel();
    }

    /**
     * 获取url和pathId
     */
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, channel_id());
        pathId = SqlGeneral.getInterfacePathValue(channel_id(), key).getId();
    }

    /**
     * 解析json key (result实际是obj格式)
     */
    protected JSONObject JsonStringKeyObj(String res, String key) {
        try {
            JSONObject results = new JSONObject(res);
            return (JSONObject) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key (result实际是obj格式)
     */
    protected JSONArray JsonStringKeyArray(String res, String key) {
        try {
            JSONObject results = new JSONObject(res);
            return (JSONArray) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key (result实际是obj格式)
     */
    protected int JsonStringKeyInt(String res, String key) {
        try {
            JSONObject results = new JSONObject(res);
            return (int) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return Integer.parseInt(null);
    }

    /**
     * 解析json key (result实际是obj格式)
     */
    protected String JsonStringKeyString(String res, String key) {
        try {
            JSONObject results = new JSONObject(res);
            return (String) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key (result实际是array格式)
     */
    protected JSONArray JsonArrayKeyArray(ArrayList res, String key) {
        try {
            for (int i = 0; i < res.size(); i++) {
                JSONObject jsonObject = (JSONObject) res.get(i);
                return (JSONArray) jsonObject.get(key);
            }
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key (result实际是array格式)
     */
    protected String JsonArrayKeyString(ArrayList res, String key, int num) {
        try {
            JSONObject jsonObject = (JSONObject) res.get(num);
            return (String) jsonObject.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key (result实际是array格式)
     */
    protected int JsonArrayKeyInt(ArrayList res, String key, int num) {
        try {
            JSONObject jsonObject = (JSONObject) res.get(num);
            return (int) jsonObject.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return Integer.parseInt(null);
    }



    /**
     * 解析json result
     */
    protected JSONObject JsonResult() {
        try {
            return new JSONObject(result);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析result
     */
    @SuppressWarnings("unchecked")
    protected <T> T sparseJsonResult(Class<T> clazz) {
        return JSON.parseObject(result, clazz);
    }

    /**
     * 解析data
     */
    @SuppressWarnings("unchecked")
    protected <T> T sparseJson(Class<T> clazz) {
        return JSON.parseObject(JsonStringKeyObj(result, "data").toString(), clazz);
    }

    /**
     * 解析dataList
     */
    @SuppressWarnings("unchecked")
    protected <T> T sparseJsonList(Class<T> clazz) {
        return (T) JSON.parseArray(JsonStringKeyArray(result, "data").toString(), clazz);
    }


    /**
     * get请求，不要断言
     */
    protected void process() {
        System.out.println(url);
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.getStringResult(channel_id(), url, pathId, this.param);
    }

    /**
     * get请求，要基本断言,errno和data
     */
    protected void process(boolean isAssert) {
        process();
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * get请求,要基本断言加list
     */
    protected void process(boolean isAssert,boolean isList) {
        process();
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * post请求,不要断言
     */
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.postStringResult(channel_id(), url, pathId, list);
    }

    /**
     * post请求，要基本断言，errno和data
     */
    protected void process(List<NameValuePair> list, boolean isAssert) {
        process(list);
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * post请求，要基本断言加list
     */
    protected void process(List<NameValuePair> list, boolean isAssert, boolean isList) {
        process(list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * post（json传参）请求,不要断言
     */
    protected void process(String param) {
        System.out.println(url);
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.postStringResult(channel_id(), url, pathId, param);
    }

    /**
     * post（json传参）请求，要基本断言，errno和data
     */
    protected void process(String param, boolean isAssert) {
        process(param);
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * post（json传参）请求，要基本断言加list
     */
    protected void process(String param, boolean isAssert, boolean isList) {
        process(param);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * delete请求，不要断言
     */
    protected void processDelete() {
        System.out.println(url);
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.deleteStringResult(channel_id(), url, pathId, this.param);
    }

    /**
     * delete请求，要基本断言，errno和data
     */
    protected void processDelete(boolean isAssert) {
        processDelete();
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * delete请求，要基本断言加list
     */
    protected void processDelete(boolean isAssert, boolean isList) {
        processDelete();
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * 通用断言判断，只判断errno
     */
    protected void statusAssertTest() {
        GeneralAssertChannel.errnoAssert(channel_id(), String.valueOf(JsonStringKeyInt(result, "errno")), JsonStringKeyString(result, "errmsg"), url, pathId, param, result);
    }

    /**
     * 通用断言判断errno和data
     */
    protected void generalAssertTest() {
        statusAssertTest();
        GeneralAssertChannel.dataAssert(channel_id(), JsonStringKeyObj(result, "data"), url, pathId, param, result);
    }

    /**
     * 通用断言判断errno和data和list
     */
    protected void generalAssertTest(boolean isList) {
        generalAssertTest();
        if (isList == true) {
            GeneralAssertChannel.listAssert(channel_id(), JsonStringKeyArray(JsonStringKeyObj(result, "data").toString(), "list"), url, pathId, param, result);
        }
    }

    /**
     * 通用断言判断errno和dataList
     */
    protected void generalAssertTest(boolean isDataList, boolean isList) {

        try {
            if (isDataList == true) {
                statusAssertTest();
                GeneralAssertChannel.dataAssert(channel_id(), JsonStringKeyArray(result, "data"), url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < JsonStringKeyArray(result, "data").length(); i++) {
                        JSONObject json = (JSONObject) JsonStringKeyArray(result, "data").get(i);
                        GeneralAssertChannel.listAssert(channel_id(), (JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
    }


    /**
     * 详细断言 具体返回值对比 int
     */
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 详细断言 具体返回值对比 String
     */
    protected void detailAssertTest (String assertValue, String resultKey, String resultValue) {
        if (assertValue == null) {
            if (resultValue != null) {
                GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                        resultValue, url, pathId, param, result);
            }
        }else if (!resultValue.equals(assertValue)) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 详细断言 具体返回值对比 boolean
     */
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert( channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 判断返回的数组是否为空
     */
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    /**
     * 判断字段/对象是否为空，不会验证返回结果是否为0
     */
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 判断字段是否为空，int类型，验证返回结果是否为0用此方法
     */
    protected void detailAssertTest (String resultKey, int resultValue) {
        String resultValues = String.valueOf(resultValue);
        if (resultValues == null || resultValues.isEmpty() || resultValues.equals("0") ) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 判断字段是否为空，boolean类型
     */
    protected void detailAssertTest (String resultKey, boolean resultValue) {
        detailAssertTest(resultKey, String.valueOf(resultValue));
    }

}
