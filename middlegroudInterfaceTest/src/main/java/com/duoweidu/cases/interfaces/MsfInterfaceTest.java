package com.duoweidu.cases.interfaces;

import com.duoweidu.config.MsfConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class MsfInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getInstance().getParamValue(0, "version") +
                "&token=" + MsfConfig.token +
                "&lng=" + SqlDetail.getInstance().getParamValue(0, "lng") +
                "&lat=" + SqlDetail.getInstance().getParamValue(0, "lat") +
                "&zone_id=" + SqlDetail.getInstance().getParamValue(0, "zone_id") +
                "&platform=" + SqlDetail.getInstance().getParamValue(0, "platform");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterface.getStringResult(url, pathId, this.param);
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("token", MsfConfig.token));
        list.add(new BasicNameValuePair("lng", SqlDetail.getInstance().getParamValue(0, "lng")));
        list.add(new BasicNameValuePair("lat", SqlDetail.getInstance().getParamValue(0, "lat")));
        list.add(new BasicNameValuePair("zone_id", SqlDetail.getInstance().getParamValue(0, "zone_id")));
        list.add(new BasicNameValuePair("platform", SqlDetail.getInstance().getParamValue(0, "platform")));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterface.postStringResult(url, pathId, list);
    }
}
