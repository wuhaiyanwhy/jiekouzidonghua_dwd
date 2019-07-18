package com.duoweidu.utils;

import com.duoweidu.config.GeneralConfig;
import com.duoweidu.config.sql.SqlGeneral;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.codehaus.plexus.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class JenkinsCallbackInterface extends CallbackInterface {

    private static final String key = SqlGeneral.getParamValue(11, 0, "username").getValue();
    private static final String value = SqlGeneral.getParamValue(11, 0, "password").getValue();

    private static String getHeader() {
        String auth = key + ":" + value;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }

    public static String postStringResult(String url, int path_id, List<NameValuePair> list) {
        HttpPost post = new HttpPost(url);
        post.addHeader("Authorization", getHeader());
        CallbackInterface.defaultHttpClient.setCookieStore(GeneralConfig.store);
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(list, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = defaultHttpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult(11, response, url, path_id, list.toString());
    }
}
