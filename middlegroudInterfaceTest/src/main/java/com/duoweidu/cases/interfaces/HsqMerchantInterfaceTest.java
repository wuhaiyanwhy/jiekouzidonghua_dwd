package com.duoweidu.cases.interfaces;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.generalAssert.GeneralAssertMultiChannel2;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.ConfigFileUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HsqMerchantInterfaceTest extends InterfaceTest {

    protected GeneralAssert generalAssert = new GeneralAssertMultiChannel2();

    @Override
    //获取url和pathId
    protected void setUrl(String key) {
        url = ConfigFileUrl.getUrlByKey(key, ConfigFileUrl.getChannel2());
        pathId = SqlGeneral.getInterfacePathValue(ConfigFileUrl.getChannel2(), key).getId();
    }

    //通用断言判断，只判断errno
    @Override
    protected void statusAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            generalAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
        }catch (JSONException e){
            generalAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    //通用断言判断errno和data
    @Override
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            generalAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            generalAssert.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
        }catch (JSONException e){
            generalAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            generalAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            generalAssert.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
            if (isList == true) {
                generalAssert.listAssert((JSONArray) data.get("list"), url, pathId, param, result);
            }
        }catch (JSONException e){
            generalAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList, boolean isDataList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (isDataList == true) {
                JSONArray data = (JSONArray) jsonObject.get("data");
                generalAssert.errnoAssert(data.toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                generalAssert.dataAssert(data, url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject json = (JSONObject) data.get(i);
                        generalAssert.listAssert((JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            generalAssert.jsonAssert(url, pathId, param, result, e);
        }
    }

    @Override
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            generalAssert.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (String assertValue, String resultKey, String resultValue) {
        if (assertValue == null) {
            if (resultValue != null) {
                generalAssert.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                        resultValue, url, pathId, param, result);
            }
        }else if (!resultValue.equals(assertValue)) {
            generalAssert.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            generalAssert.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断返回的数组是否为空
    @Override
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            generalAssert.detailedAssert("返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    //判断字段/对象是否为空，不会验证返回结果是否为0
    @Override
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            generalAssert.detailedAssert("返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断字段是否为空，int类型，验证返回结果是否为0用此方法
    @Override
    protected void detailAssertTest (String resultKey, int resultValue) {
        String resultValues = String.valueOf(resultValue);
        if (resultValues == null || resultValues.isEmpty() || resultValues.equals("0") ) {
            generalAssert.detailedAssert("返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

}
