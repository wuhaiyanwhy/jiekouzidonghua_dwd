package com.duoweidu.config.generalAssert;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class GeneralAssertChannel extends Assert {

    /**
     * 不是调试状态才往库里插入数据，线上环境会插入报错次数
     * @param channel_id
     * @param uri
     * @param path_id
     * @param param
     * @param status
     * @param errnoResult
     */
    public void genErrno(int channel_id, String uri, int path_id, String param, int status, String errnoResult) {
        if ("false".equals(ConfigFileUrl.getDebug())) {
            //插入报错数据
            SqlGeneral.insertErrnoResult(channel_id, path_id, SqlGeneral.getBuildId().getId() + 1, param, status, errnoResult);
            GeneralConfig.errnoList.add(uri);
            if ("prod".equals(ConfigFileUrl.getEnv())) {
                //插入报错次数
                SqlGeneral.updateInterfacePathErrnoCount(path_id, channel_id,
                        SqlGeneral.getInterfacePathValue(path_id, channel_id).getErrno_count() + 1);
            }
        }
    }

    /**
     * 拼接报错结果
     * @param channel_id
     * @param faile
     * @param uri
     * @param param
     * @param result
     * @param status
     * @return
     */
    public static String distinguishParamFailed(int channel_id, String faile, String uri, int path_id, String param, int status, String result) {
        String failed = null;
        String parameterFailed = null;
        String errnoResult = null;
        failed = "\n" + faile +
                "\n请求的url:" + uri +
                "\ncookie：" + GeneralConfig.store +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        parameterFailed = "\n" + faile +
                "\n请求的url:" + uri +
                "\n参数：" + param +
                "\ncookie：" + GeneralConfig.store +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        errnoResult = faile +
                "\ncookie：" + GeneralConfig.store +
                "\n接口返回：" + result;

        //觅食蜂报错需要X-Request-ID
        if (ConfigFileUrl.getChannel() == 3) {
            Header header[] = GeneralConfig.response.getHeaders("X-Request-ID");

            String requsetId = null;
            if (header.length > 0) {
                requsetId = header[0].getValue();
            }

            failed = "\n" + faile +
                    "\n请求的url:" + uri +
                    "\nCX-Request-ID: " + requsetId +
                    "\n接口返回：" + result +
                    "\n《-------------------------分割线-------------------------》";
            parameterFailed = "\n" + faile +
                    "\n请求的url:" + uri +
                    "\n参数：" + param +
                    "\nCX-Request-ID: " + requsetId +
                    "\n接口返回：" + result +
                    "\n《-------------------------分割线-------------------------》";
            errnoResult = faile +
                    "\nCX-Request-ID: " + requsetId +
                    "\n接口返回：" + result;
        }

        GeneralAssert generalAssert = new GeneralAssert();
        generalAssert.genErrno(channel_id, uri, path_id, param, status, errnoResult);

        if (param == null) {
            return failed;
        } else {
            return parameterFailed;
        }
    }


    public static void timeTest(int channel_id, long limitTime, long responseTime, HttpResponse response, String uri, int path_id, String param) {
        if(responseTime >= limitTime){
            //需要一个HTTP_好的状态从响应和不得到它，你仍然必须消耗实体
            if (response.getEntity() != null) {
                try {
                    response.getEntity().consumeContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fail(distinguishParamFailed(channel_id, "接口响应超时;\n限制时间：" + limitTime + "ms;  实际响应时间：" + responseTime + "ms", uri, path_id, param, 1, null));
        }

    }

    /**
     * 判断返回的code
     * @param channel_id
     * @param response
     * @param uri
     * @param param
     */
    public static void codeAssert(int channel_id, HttpResponse response, String uri, int path_id, String param) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            //需要一个HTTP_好的状态从响应和不得到它，你仍然必须消耗实体
            if (response.getEntity() != null) {
                try {
                    response.getEntity().consumeContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fail(distinguishParamFailed(channel_id, "返回的code不等于200;\n返回的code:" + statusCode, uri, path_id, param, 1, null));
        }

    }

    /**
     * 判断返回的结果
     * @param channel_id
     * @param uri
     * @param param
     * @param result
     */
    public static void resultAssert(int channel_id, String uri, int path_id, String param, String result) {
        if (result == null || result.equals("")) {
            fail(distinguishParamFailed(channel_id, "返回的数据为空;", uri, path_id, param, 2, result));
        }
    }

    /**
     * 判断返回的errno/errmsg
     * @param channel_id
     * @param errno
     * @param errmsg
     * @param uri
     * @param param
     * @param result
     */
    public static void errnoAssert(int channel_id, String errno, String errmsg, String uri, int path_id, String param, String result) {
        if (!errno.equals("0") || !errmsg.equals("success")) {
            fail(distinguishParamFailed(channel_id, "返回的errno不为0/errmsg不为success;\n返回的errno/errmsg:" + errno + "/" + errmsg, uri, path_id, param, 3, result));
        }
    }

    /**
     * 判断返回信息status下的code与message(iqg)
     * @param channel_id
     * @param status
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void statusTest(int channel_id, JSONObject status, String uri, int path_id, String param, String result) {

        if (!status.get("code").toString().equals("10000")) {
            fail(distinguishParamFailed(channel_id, "返回的status中code/message不正确;\n返回的status:" + status.toString(), uri, path_id, param, 3, result));
        }else if (!status.get("message").toString().equals("成功") && !status.get("message").toString().equals("success")) {
            fail(distinguishParamFailed(channel_id, "返回的status中code/message不正确;\n返回的status:" + status.toString(), uri, path_id, param, 3, result));
        }
    }


    /**
     * 判断返回的data
     * @param channel_id
     * @param data
     * @param uri
     * @param param
     * @param result
     */
    public static void dataAssert(int channel_id, Object data, String uri, int path_id, String param, String result) {
        if (data.equals("{}")) {
            fail(distinguishParamFailed(channel_id, "返回的data数据为空;", uri, path_id, param, 4, result));
        }
    }

    /**
     * 判断返回的data
     * @param channel_id
     * @param data
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void dataAssert(int channel_id, JSONArray data, String uri, int path_id, String param, String result) {
        if (data.equals("{}")) {
            fail(distinguishParamFailed(channel_id, "返回的data数据为空;", uri, path_id, param, 4, result));
        }
    }

    /**
     * 判断返回的aaData
     * @param channel_id
     * @param aaData
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void aaDataTest(int channel_id, JSONArray aaData, String uri, int path_id, String param, String result) {
        if(aaData.length() <= 0){
            fail(distinguishParamFailed(channel_id, "返回的aaData数据为空;", uri, path_id, param, 4, result));
        }

    }


    /**
     * 判断返回的list
     * @param channel_id
     * @param list
     * @param uri
     * @param param
     * @param result
     */
    public static void listAssert(int channel_id, JSONArray list, String uri, int path_id, String param, String result) {
        if (list.length() <= 0) {
            fail(distinguishParamFailed(channel_id, "返回的list数据为空;", uri, path_id, param, 5, result));
        }
    }

    /**
     * 判断json解析错误
     * @param channel_id
     * @param uri
     * @param param
     * @param result
     * @param e
     */
    public static void jsonAssert(int channel_id, String uri, int path_id, String param, String result, JSONException e) {
        fail(distinguishParamFailed(channel_id, "json解析错误;" +
                "\n报错的代码:" + e.toString(), uri, path_id, param, 6, result));
    }

    /**
     * 判断详细断言
     * @param channel_id
     * @param faile
     * @param uri
     * @param path_id
     * @param param
     * @param result
     */
    public static void detailedAssert(int channel_id, String faile, String uri, int path_id, String param, String result) {
        fail(distinguishParamFailed(channel_id, faile, uri, path_id, param, 7, result));
    }


}
