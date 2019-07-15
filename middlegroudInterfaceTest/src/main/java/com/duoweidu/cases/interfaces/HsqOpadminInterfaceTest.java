package com.duoweidu.cases.interfaces;

import com.duoweidu.config.generalAssert.GeneralAssertChannel;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HsqOpadminInterfaceTest extends InterfaceTest {

    @Override
    //获取url和pathId
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, ConfigFileUrl.getChannel1());
        pathId = SqlGeneral.getInterfacePathValue(ConfigFileUrl.getChannel1(), key).getId();
    }

    //get请求,type=1 ==> data, type=2 ==>aaData
    protected void process(int type, boolean isAssert, boolean isList) {
        System.out.println(url);
        result = CallbackInterface.getStringResult(url, pathId, this.param);
        if (isAssert == true) {
            generalAssertTest(type, isList);
        }
    }

    //post请求,type=1 ==> data, type=2 ==>aaData
    protected void process(List<NameValuePair> list, int type, boolean isAssert, boolean isList) {
        System.out.println(url);
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(type, isList);
        }
    }

    //type=1 ==> data, type=2 ==>aaData
    protected void generalAssertTest(int type, boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (type == 1) {
                JSONObject data = (JSONObject) jsonObject.get("data");
                GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel1(), jsonObject.get("data").toString(), url, pathId, param, result);
                if (isList == true) {
                    GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), (JSONArray) data.get("list"), url, pathId, param, result);
                }
            }else if (type == 2) {
                JSONArray aaData = (JSONArray) jsonObject.get("aaData");
                GeneralAssertChannel.aaDataTest(ConfigFileUrl.getChannel1(), aaData, url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }

    }


    //通用断言判断，只判断errno
    @Override
    protected void statusAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }
    }

    //通用断言判断errno和data
    @Override
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel1(), jsonObject.get("data").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel1(), jsonObject.get("data").toString(), url, pathId, param, result);
            if (isList == true) {
                GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), (JSONArray) data.get("list"), url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList, boolean isDataList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (isDataList == true) {
                JSONArray data = (JSONArray) jsonObject.get("data");
                GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel1(), data.toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel1(), data, url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject json = (JSONObject) data.get(i);
                        GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel1(), (JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel1(), url, pathId, param, result, e);
        }
    }



    @Override
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (String assertValue, String resultKey, String resultValue) {
        if (assertValue == null) {
            if (resultValue != null) {
                GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                        resultValue, url, pathId, param, result);
            }
        }else if (!resultValue.equals(assertValue)) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断返回的数组是否为空
    @Override
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    //判断字段/对象是否为空，不会验证返回结果是否为0
    @Override
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断字段是否为空，int类型，验证返回结果是否为0用此方法
    @Override
    protected void detailAssertTest (String resultKey, int resultValue) {
        String resultValues = String.valueOf(resultValue);
        if (resultValues == null || resultValues.isEmpty() || resultValues.equals("0") ) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel1(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }


}
