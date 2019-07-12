package com.duoweidu.cases.interfaces;

import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class MsfInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getParamValue(0, "version") +
                "&token=" + MsfConfig.token +
                "&lng=" + SqlDetail.getParamValue(0, "lng") +
                "&lat=" + SqlDetail.getParamValue(0, "lat") +
                "&zone_id=" + SqlDetail.getParamValue(0, "zone_id") +
                "&platform=" + SqlDetail.getParamValue(0, "platform");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = CallbackInterface.getStringResult(url, pathId, this.param);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list, boolean isAssert, boolean isList) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("version", SqlDetail.getParamValue(0, "version")));
        list.add(new BasicNameValuePair("token", MsfConfig.token));
        list.add(new BasicNameValuePair("lng", SqlDetail.getParamValue(0, "lng")));
        list.add(new BasicNameValuePair("lat", SqlDetail.getParamValue(0, "lat")));
        list.add(new BasicNameValuePair("zone_id", SqlDetail.getParamValue(0, "zone_id")));
        list.add(new BasicNameValuePair("platform", SqlDetail.getParamValue(0, "platform")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }
}
