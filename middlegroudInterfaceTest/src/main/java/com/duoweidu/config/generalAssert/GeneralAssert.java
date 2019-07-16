package com.duoweidu.config.generalAssert;

import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralAssert extends GeneralAssertChannel {


    public final static int channel_id = ConfigFileUrl.getChannel();

    /**
     * 判断返回的code
     *
     * @param response
     * @param uri
     * @param param
     */
    public static void codeAssert(HttpResponse response, String uri, int path_id, String param) {
        GeneralAssertChannel.codeAssert(channel_id, response, uri, path_id, param);
    }

    /**
     * 判断返回的结果
     *
     * @param uri
     * @param param
     * @param result
     */
    public static void resultAssert(String uri, int path_id, String param, String result) {
        GeneralAssertChannel.resultAssert(channel_id, uri, path_id, param, result);
    }

    /**
     * 判断返回的errno/errmsg
     *
     * @param errno
     * @param errmsg
     * @param uri
     * @param param
     * @param result
     */
    public static void errnoAssert(String errno, String errmsg, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.errnoAssert(channel_id, errno, errmsg, uri, path_id, param, result);
    }

    /**
     * 判断返回信息status下的code与message(iqg)
     * @param status
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void statusTest(JSONObject status, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.statusTest(channel_id, status, uri, path_id, param, result);
    }


    /**
     * 判断返回的data
     * @param data
     * @param uri
     * @param param
     * @param result
     */
    public static void dataAssert(Object data, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.dataAssert(channel_id, data, uri, path_id, param, result);
    }

    /**
     * 判断返回的data
     * @param data
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void dataAssert(JSONArray data, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.dataAssert(channel_id, data, uri, path_id, param, result);
    }

    /**
     * 判断返回的aaData
     * @param aaData
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void aaDataTest(JSONArray aaData, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.aaDataTest(channel_id, aaData, uri, path_id, param, result);
    }


    /**
     * 判断返回的list
     *
     * @param list
     * @param uri
     * @param param
     * @param result
     */
    public static void listAssert(JSONArray list, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.listAssert(channel_id, list, uri, path_id, param, result);
    }

    /**
     * 判断json解析错误
     *
     * @param uri
     * @param param
     * @param result
     * @param e
     */
    public static void jsonAssert(String uri, int path_id, String param, String result, JSONException e) {
        GeneralAssertChannel.jsonAssert(channel_id, uri, path_id, param, result, e);
    }

    /**
     * 判断详细断言
     *
     * @param faile
     * @param uri
     * @param param
     * @param result
     */
    public static void detailedAssert(String faile, String uri, int path_id, String param, String result) {
        GeneralAssertChannel.dataAssert(channel_id, faile, uri, path_id, param, result);
    }


}
