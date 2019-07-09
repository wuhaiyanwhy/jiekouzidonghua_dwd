package com.duoweidu.config;

import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.Header;

public class MsfGeneralAssert extends GeneralAssert {


    public static String distinguishParamFailed(String faile, String uri, int path_id, String param, int status, String result) {
        String failed = null;
        String parameterFailed = null;
        String errnoResult = null;
        Header header[] = GeneralConfig.response.getHeaders("X-Request-ID");
        failed = "\n" + faile +
                "\n请求的url:" + uri +
                "\nCX-Request-ID: " + header[0].getValue() +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        parameterFailed = "\n" + faile +
                "\n请求的url:" + uri +
                "\n参数：" + param +
                "\nCX-Request-ID: " + header[0].getValue() +
                "\n接口返回：" + result +
                "\n《-------------------------分割线-------------------------》";
        errnoResult = faile +
                "\nCX-Request-ID: " + header[0].getValue() +
                "\n接口返回：" + result;
        /**
         * 如果不是线上环境/调试状态时则不调用报错相关预警
         */
        //插入报错数据
        SqlDetail.insertErrnoResult(path_id, param, status, errnoResult);
        GeneralConfig.errnoList.add(uri);
        if ("prod".equals(ConfigFileUrl.getEnv()) && "false".equals(ConfigFileUrl.getDebug())) {
            //插入报错次数
            SqlDetail.updatePathErrnoCount(path_id);
        }
        if (param == null) {
            return failed;
        } else {
            return parameterFailed;
        }
    }

}
