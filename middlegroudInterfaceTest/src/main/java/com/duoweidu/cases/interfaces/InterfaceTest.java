package com.duoweidu.cases.interfaces;

import com.alibaba.fastjson.JSON;
import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.CallbackInterfaceChannel;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
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
     * @return
     */
    public int channel_id() {
        return ConfigFileUrl.getChannel();
    }

    /**
     * 获取url和pathId
     * @param key
     */
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, channel_id());
        pathId = SqlGeneral.getInterfacePathValue(channel_id(), key).getId();
    }

    /**
     * 解析json obj
     * @return
     */
    protected JSONObject JsonKey(JSONObject key) {
        try {
            return key;
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json array
     * @return
     */
    protected JSONArray JsonKey(JSONArray key) {
        try {
            return key;
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json int
     * @return
     */
    protected int JsonKey(int key) {
        try {
            return key;
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return Integer.parseInt(null);
    }

    /**
     * 解析json String
     * @return
     */
    protected String JsonKey(String key) {
        try {
            return key;
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json result
     * @return
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
     * 解析json key
     * @return
     */
    protected JSONObject JsonKeyObj(String key) {
        try {
            JSONObject results = JsonResult();
            return (JSONObject) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json key
     * @return
     */
    protected int JsonKeyInt(String key) {
        try {
            JSONObject results = JsonResult();
            return (int) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return Integer.parseInt(null);
    }

    /**
     * 解析json key
     * @return
     */
    protected String JsonKeyString(String key) {
        try {
            JSONObject results = JsonResult();
            return (String) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json keyList
     * @return
     */
    protected JSONArray JsonKeyList(String key) {
        try {
            JSONObject results = JsonResult();
            return (JSONArray) results.get(key);
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }

    /**
     * 解析json errno
     * @return
     */
    protected int JsonErrno() {
        return JsonKeyInt("errno");
    }

    /**
     * 解析json errnmsg
     * @return
     */
    protected String JsonErrmsg() {
        return JsonKeyString("errmsg");
    }

    /**
     * 解析json data
     * @return
     */
    protected JSONObject JsonData() {
        return JsonKeyObj("data");
    }

    /**
     * 解析json dataList
     * @return
     */
    protected JSONArray JsonDataList() {
        return JsonKeyList("data");
    }

    /**
     * 解析json List
     * @return
     */
    protected JSONArray JsonList() {
        try {
            return (JSONArray) JsonData().get("list");
        }catch (JSONException e) {
            GeneralAssertChannel.jsonAssert(channel_id(), url, pathId, param, result, e);
        }
        return null;
    }


    /**
     * 解析result
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T sparseJsonResult(Class<T> clazz) {
        return JSON.parseObject(result, clazz);
    }

    /**
     * 解析data
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T sparseJson(Class<T> clazz) {
        return JSON.parseObject(JsonData().toString(), clazz);
    }

    /**
     * 解析dataList
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T sparseJsonList(Class<T> clazz) {
        return (T) JSON.parseArray(JsonDataList().toString(), clazz);
    }


    /**
     * get请求，不要断言
     */
    protected void process() {
        System.out.println(url);
        result = CallbackInterfaceChannel.getStringResult(channel_id(), url, pathId, this.param);
    }

    /**
     * get请求，要基本断言,errno和data
     * @param isAssert
     */
    protected void process(boolean isAssert) {
        process();
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * get请求,要基本断言加list
     * @param isAssert
     * @param isList
     */
    protected void process(boolean isAssert,boolean isList) {
        process();
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * post请求,不要断言
     * @param list
     */
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        param = list.toString();
        result = CallbackInterfaceChannel.postStringResult(channel_id(), url, pathId, list);
    }

    /**
     * post请求，要基本断言，errno和data
     * @param list
     * @param isAssert
     */
    protected void process(List<NameValuePair> list, boolean isAssert) {
        process(list);
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * post请求，要基本断言加list
     * @param list
     * @param isAssert
     * @param isList
     */
    protected void process(List<NameValuePair> list, boolean isAssert, boolean isList) {
        process(list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    /**
     * post（json传参）请求,不要断言
     * @param param
     */
    protected void process(String param) {
        System.out.println(url);
        result = CallbackInterfaceChannel.postStringResult(channel_id(), url, pathId, param);
    }

    /**
     * post（json传参）请求，要基本断言，errno和data
     * @param param
     * @param isAssert
     */
    protected void process(String param, boolean isAssert) {
        process(param);
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * post（json传参）请求，要基本断言加list
     * @param param
     * @param isAssert
     * @param isList
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
        result = CallbackInterfaceChannel.deleteStringResult(channel_id(), url, pathId, this.param);
    }

    /**
     * delete请求，要基本断言，errno和data
     * @param isAssert
     */
    protected void processDelete(boolean isAssert) {
        processDelete();
        if (isAssert == true) {
            generalAssertTest();
        }
    }

    /**
     * delete请求，要基本断言加list
     * @param isAssert
     * @param isList
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
        GeneralAssertChannel.errnoAssert(channel_id(), String.valueOf(JsonErrno()), JsonErrmsg(), url, pathId, param, result);
    }

    /**
     * 通用断言判断errno和data
     */
    protected void generalAssertTest() {
        statusAssertTest();
        GeneralAssertChannel.dataAssert(channel_id(), JsonData(), url, pathId, param, result);
    }

    /**
     * 通用断言判断errno和data和list
     * @param isList
     */
    protected void generalAssertTest(boolean isList) {
        generalAssertTest();
        if (isList == true) {
            GeneralAssertChannel.listAssert(channel_id(), JsonList(), url, pathId, param, result);
        }
    }

    /**
     * 通用断言判断errno和dataList
     * @param isDataList
     * @param isList
     */
    protected void generalAssertTest(boolean isDataList, boolean isList) {

        try {
            if (isDataList == true) {
                statusAssertTest();
                GeneralAssertChannel.dataAssert(channel_id(), JsonDataList(), url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < JsonDataList().length(); i++) {
                        JSONObject json = (JSONObject) JsonDataList().get(i);
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
     * @param assertValue
     * @param resultKey
     * @param resultValue
     */
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 详细断言 具体返回值对比 String
     * @param assertValue
     * @param resultKey
     * @param resultValue
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
     * @param assertValue
     * @param resultKey
     * @param resultValue
     */
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert( channel_id(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 判断返回的数组是否为空
     * @param resultKey
     * @param resultValue
     */
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    /**
     * 判断字段/对象是否为空，不会验证返回结果是否为0
     * @param resultKey
     * @param resultValue
     */
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            GeneralAssertChannel.detailedAssert(channel_id(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    /**
     * 判断字段是否为空，int类型，验证返回结果是否为0用此方法
     * @param resultKey
     * @param resultValue
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
     * @param resultKey
     * @param resultValue
     */
    protected void detailAssertTest (String resultKey, boolean resultValue) {
        detailAssertTest(resultKey, String.valueOf(resultValue));
    }

}
