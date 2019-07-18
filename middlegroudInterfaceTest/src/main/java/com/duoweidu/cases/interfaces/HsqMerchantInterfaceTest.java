package com.duoweidu.cases.interfaces;

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

public class HsqMerchantInterfaceTest extends InterfaceTest {

    public static final int channel_id = ConfigFileUrl.getChannel2();

    @Override
    //获取url和pathId
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, ConfigFileUrl.getChannel2());
        pathId = SqlGeneral.getInterfacePathValue(ConfigFileUrl.getChannel2(), key).getId();
    }


    //get请求，不要断言
    @Override
    protected void process() {
        System.out.println(url);
        result = CallbackInterfaceChannel.getStringResult(channel_id, url, pathId, this.param);
    }

    //post请求,不要断言
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        param = list.toString();
        result = CallbackInterfaceChannel.postStringResult(channel_id, url, pathId, list);
    }

    //通用断言判断，只判断errno
    @Override
    protected void statusAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel2(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel2(), url, pathId, param, result, e);
        }
    }

    //通用断言判断errno和data
    @Override
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel2(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel2(), jsonObject.get("data").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel2(), url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel2(), jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel2(), jsonObject.get("data").toString(), url, pathId, param, result);
            if (isList == true) {
                GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel2(), (JSONArray) data.get("list"), url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel2(), url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList, boolean isDataList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (isDataList == true) {
                JSONArray data = (JSONArray) jsonObject.get("data");
                GeneralAssertChannel.errnoAssert(ConfigFileUrl.getChannel2(), data.toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssertChannel.dataAssert(ConfigFileUrl.getChannel2(), data, url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject json = (JSONObject) data.get(i);
                        GeneralAssertChannel.listAssert(ConfigFileUrl.getChannel2(), (JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            GeneralAssertChannel.jsonAssert(ConfigFileUrl.getChannel2(), url, pathId, param, result, e);
        }
    }

    @Override
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (String assertValue, String resultKey, String resultValue) {
        if (assertValue == null) {
            if (resultValue != null) {
                GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                        resultValue, url, pathId, param, result);
            }
        }else if (!resultValue.equals(assertValue)) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断返回的数组是否为空
    @Override
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    //判断字段/对象是否为空，不会验证返回结果是否为0
    @Override
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断字段是否为空，int类型，验证返回结果是否为0用此方法
    @Override
    protected void detailAssertTest (String resultKey, int resultValue) {
        String resultValues = String.valueOf(resultValue);
        if (resultValues == null || resultValues.isEmpty() || resultValues.equals("0") ) {
            GeneralAssertChannel.detailedAssert(ConfigFileUrl.getChannel2(), "返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

}
