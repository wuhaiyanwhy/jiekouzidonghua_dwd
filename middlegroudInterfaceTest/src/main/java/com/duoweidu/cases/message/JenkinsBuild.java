package com.duoweidu.cases.message;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlGeneral;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static com.duoweidu.utils.JenkinsCallbackInterface.postStringResult;

/**
 * 获取构建相关信息
 */
public class JenkinsBuild {

    public static void jenkinsLastBuild() {
        String uri = "hsq.prod.lastBuild.uri";
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            if (ConfigFileUrl.getChannel() == 1){
                uri = "hsq.beta.lastBuild.uri";
            }else if (ConfigFileUrl.getChannel() == 2) {
                uri = "iqg.beta.lastBuild.uri";
            }else if (ConfigFileUrl.getChannel() == 3) {
                uri = "msf.beta.lastBuild.uri";
            }
        }else if ("prod".equals(ConfigFileUrl.getEnv())) {
            if (ConfigFileUrl.getChannel() == 2){
                uri = "iqg.prod.lastBuild.uri";
            }else if (ConfigFileUrl.getChannel() == 3) {
                uri = "msf.prod.lastBuild.uri";
            }else if (ConfigFileUrl.getChannel() == 4) {
                uri = "fyb.prod.lastBuild.uri";
            }else if (ConfigFileUrl.getChannel() == 5) {
                uri = "jsz.prod.lastBuild.uri";
            }
        }


        String url = ConfigFileUrl.getUrlByKey(11, 0, uri);
        System.out.println(url);
        List<NameValuePair> list = new LinkedList<>();
        String result = postStringResult(url, SqlGeneral.getInterfacePathValue(11, uri).getId(), list);
        JSONObject jsonObject = new JSONObject(result);
        GeneralConfig.url = jsonObject.getString("url");
        System.out.println(GeneralConfig.url);

    }
}
