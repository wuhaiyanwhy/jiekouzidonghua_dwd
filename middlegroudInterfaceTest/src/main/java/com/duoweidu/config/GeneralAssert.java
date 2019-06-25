package com.duoweidu.config;

import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;

import java.io.IOException;

public class GeneralAssert extends Assert {

    /**
     * 拼接报错结果
     * @param faile
     * @param uri
     * @param param
     * @param result
     * @param status
     * @return
     */
    public static String distinguishParamFailed(String faile,String uri,String param,String result,int status) {
        String failed = null;
        String parameterFailed = null;
        String errnoResult = null;
        failed = "\n" + faile +
                "\n请求的url:" + uri +
//                "\ncookie：" + TestConfigOpenapi.store +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        parameterFailed =  "\n" + faile +
                "\n请求的url:" + uri +
                "\n参数：" + param +
//                "\ncookie：" + TestConfigOpenapi.store +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        errnoResult = faile +
//                "\ncookie：" + TestConfigOpenapi.store +
                "\n接口返回：" + result;
        /**
         * 如果不是线上环境/调试状态时则不调用报错相关预警
         */
        if("prod".equals(ConfigFileUrl.getEnv()) && "false".equals(ConfigFileUrl.getDebug())) {
            GeneralConfig.errnoList.add(uri);
            TestSql.inesrtErrnoResult(uri,param,status,errnoResult);
        }
        if (param == null) {
            return failed;
        }else {
            return parameterFailed;
        }
    }

    /**
     * 判断返回的code
     * @param response
     * @param uri
     * @param param
     */
    public static void codeAssert(HttpResponse response, String uri, String param) {
        int statusCode =  response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            //需要一个HTTP_好的状态从响应和不得到它，你仍然必须消耗实体
            if ( response.getEntity() != null ) {
                try {
                    response.getEntity().consumeContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fail(distinguishParamFailed("返回的code不正确",uri,param,null,1));
        }

    }

    /**
     * 判断返回的结果
     * @param uri
     * @param param
     * @param result
     */
    public static void resultAssert(String uri,String param,String result) {
        if (result == null || result.equals("")) {
            fail(distinguishParamFailed("返回的数据为空;", uri, param, result, 2));
        }
    }

    /**
     * 判断返回的errno/errmsg
     * @param errno
     * @param errmsg
     * @param uri
     * @param param
     * @param result
     */
    public static void errnoAssert(String errno, String errmsg, String uri, String param, String result) {
        if(!errno.equals("0") || !errmsg.equals("success")){
            fail(distinguishParamFailed("返回的errno不为0/errmsg不为success;\n返回的errno/errmsg:" + errno + "/" + errmsg, uri, param, result,3));
        }
    }

    /**
     * 判断返回的data
     * @param data
     * @param uri
     * @param param
     * @param result
     */
    public static void dataAssert(Object data,String uri,String param,String result) {
        if(data.equals("{}")){
            fail(distinguishParamFailed("返回的data数据为空;",uri,param,result,4));
        }
    }

    /**
     * 判断返回的list
     * @param list
     * @param uri
     * @param param
     * @param result
     */
    public static void listAssert(JSONArray list, String uri, String param, String result) {
        if(list.length() <= 0){
            fail(distinguishParamFailed("返回的list数据为空;",uri,param,result,5));
        }
    }

    /**
     * 判断json解析错误
     * @param uri
     * @param param
     * @param result
     * @param e
     */
    public static void jsonAssert(String uri, String param, String result, JSONException e) {
        fail(distinguishParamFailed("json解析错误;" +
                "\n报错的代码:" + e.toString(),uri,param,result,6));
    }

    /**
     * 判断详细断言
     * @param faile
     * @param uri
     * @param param
     * @param result
     */
    public static void detailedAssert(String faile, String uri, String param, String result) {
        fail(distinguishParamFailed(faile,uri,param,result,7));
    }

}
