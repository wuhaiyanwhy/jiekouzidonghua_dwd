package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class TradeCenterInterfaceTest extends InterfaceTest {

    //交易中心的接口都是一个
    {
        url = ConfigFileUrl.getUrlByKey("gateway.http.uri");
        pathId = SqlDetail.getInstance().getPathId("gateway.http.uri");
    }

    //get请求
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getInstance().getParamValue(0, "version")
                + "&ip=" + SqlDetail.getInstance().getParamValue(0, "ip")
                + "&userId=" + SqlDetail.getInstance().getParamValue(0, "userId")
                + "&appId=" + SqlDetail.getInstance().getParamValue(0, "msfAppId");
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
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue(0, "version")));
        list.add(new BasicNameValuePair("ip", SqlDetail.getInstance().getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getInstance().getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getInstance().getParamValue(0, "msfAppId")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
    }
}
