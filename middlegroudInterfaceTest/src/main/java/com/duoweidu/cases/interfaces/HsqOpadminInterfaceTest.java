package com.duoweidu.cases.interfaces;

import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.generalAssert.GeneralAssertMultiChannel1;
import com.duoweidu.config.SqlGeneral;
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
                GeneralAssert.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssert.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
                if (isList == true) {
                    GeneralAssertMultiChannel1.listAssert((JSONArray) data.get("list"), url, pathId, param, result);
                }
            }else if (type == 2) {
                JSONArray aaData = (JSONArray) jsonObject.get("aaData");
                GeneralAssert.aaDataTest(aaData, url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertMultiChannel1.jsonAssert(url, pathId, param, result, e);
        }

    }


    //通用断言判断，只判断errno
    @Override
    protected void generalAssertTest() {
        try {
            JSONObject jsonObject = new JSONObject(result);
            GeneralAssertMultiChannel1.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
        }catch (JSONException e){
            GeneralAssertMultiChannel1.jsonAssert(url, pathId, param, result, e);
        }
    }


    @Override
    protected void generalAssertTest(boolean isList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject data = (JSONObject) jsonObject.get("data");
            GeneralAssertMultiChannel1.errnoAssert(jsonObject.get("errno").toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
            GeneralAssertMultiChannel1.dataAssert(jsonObject.get("data").toString(), url, pathId, param, result);
            if (isList == true) {
                GeneralAssertMultiChannel1.listAssert((JSONArray) data.get("list"), url, pathId, param, result);
            }
        }catch (JSONException e){
            GeneralAssertMultiChannel1.jsonAssert(url, pathId, param, result, e);
        }
    }

    //通用断言判断
    @Override
    protected void generalAssertTest(boolean isList, boolean isDataList) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (isDataList == true) {
                JSONArray data = (JSONArray) jsonObject.get("data");
                GeneralAssertMultiChannel1.errnoAssert(data.toString(), jsonObject.get("errmsg").toString(), url, pathId, param, result);
                GeneralAssertMultiChannel1.dataAssert(data, url, pathId, param, result);
                if (isList == true) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject json = (JSONObject) data.get(i);
                        GeneralAssertMultiChannel1.listAssert((JSONArray) json.get("list"), url, pathId, param, result);
                    }
                }
            }
        }catch (JSONException e){
            GeneralAssertMultiChannel1.jsonAssert(url, pathId, param, result, e);
        }
    }


    @Override
    protected void detailAssertTest (int assertValue, String resultKey, int resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (String assertValue, String resultKey, String resultValue) {
        if (assertValue == null) {
            if (resultValue != null) {
                GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                        resultValue, url, pathId, param, result);
            }
        }else if (!resultValue.equals(assertValue)) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    @Override
    protected void detailAssertTest (boolean assertValue, String resultKey, boolean resultValue) {
        if (resultValue != assertValue) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不正确，应返回：" + assertValue + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断返回的数组是否为空
    @Override
    protected void detailAssertTest (String resultKey, ArrayList resultValue) {
        if (resultValue.size() <= 0) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不应为空;", url, pathId, param, result);
        }
    }

    //判断字段/对象是否为空，不会验证返回结果是否为0
    @Override
    protected void detailAssertTest (String resultKey, String resultValue) {
        if (resultValue == null || resultValue.isEmpty() || resultValue.equals("{}")) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }

    //判断字段是否为空，int类型，验证返回结果是否为0用此方法
    @Override
    protected void detailAssertTest (String resultKey, int resultValue) {
        String resultValues = String.valueOf(resultValue);
        if (resultValues == null || resultValues.isEmpty() || resultValues.equals("0") ) {
            GeneralAssertMultiChannel1.detailedAssert("返回的" + resultKey + "不应为空/0" + "，实际返回：" +
                    resultValue, url, pathId, param, result);
        }
    }


}
