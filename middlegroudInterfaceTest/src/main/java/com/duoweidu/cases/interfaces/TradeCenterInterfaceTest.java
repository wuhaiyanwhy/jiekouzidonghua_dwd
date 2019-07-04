package com.duoweidu.cases.interfaces;

import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class TradeCenterInterfaceTest extends InterfaceTest {

    //交易中心的接口都是一个
    {
        url = ConfigFileUrl.getUrlByKey("gateway.http.uri");
        pathId = SqlDetail.getPathId("gateway.http.uri");
    }

    //get请求
    @Override
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "version=" + SqlDetail.getParamValue(0, "version")
                + "&ip=" + SqlDetail.getParamValue(0, "ip")
                + "&userId=" + SqlDetail.getParamValue(0, "userId")
                + "&appId=" + SqlDetail.getParamValue(0, "msfAppId");
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
        list.add(new BasicNameValuePair("ip", SqlDetail.getParamValue(0, "ip")));
        list.add(new BasicNameValuePair("userId", SqlDetail.getParamValue(0, "userId")));
        list.add(new BasicNameValuePair("appId", SqlDetail.getParamValue(0, "msfAppId")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }
}
