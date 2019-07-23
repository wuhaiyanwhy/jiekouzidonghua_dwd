package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class JszInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "v=" + SqlDetail.getInstance().getParamValue(0, "v")
                + "&token=" + SqlDetail.getInstance().getParamValue("token")
                + "&zoneId=" + SqlDetail.getInstance().getParamValue(0,"zoneId")
                + "&lng=" + SqlDetail.getInstance().getParamValue(0,"lng")
                + "&lat=" + SqlDetail.getInstance().getParamValue(0,"lat")
                + "&appId=" + SqlDetail.getInstance().getParamValue(0,"oauth_appid");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = CallbackInterface.getStringResult(url, pathId, this.param);
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("v", SqlDetail.getInstance().getParamValue(0, "v")));
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        list.add(new BasicNameValuePair("zoneId", SqlDetail.getInstance().getParamValue(0,"zoneId")));
        list.add(new BasicNameValuePair("lng", SqlDetail.getInstance().getParamValue(0,"lng")));
        list.add(new BasicNameValuePair("lat", SqlDetail.getInstance().getParamValue(0,"lat")));
        list.add(new BasicNameValuePair("oauth_appid", SqlDetail.getInstance().getParamValue(0,"oauth_appid")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
    }
}
