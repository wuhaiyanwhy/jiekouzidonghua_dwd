package com.duoweidu.cases.interfaces;

import com.duoweidu.config.SqlTradecenter;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class TradeCenterOpadminInterfaceTest extends InterfaceTest {

    //交易中心管理平台的接口都是一个
    {
        url = ConfigFileUrl.getUrlByKey("adminHttp");
        pathId = SqlTradecenter.getPathId("adminHttp");
    }

    //get请求
    @Override
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "token=" + SqlTradecenter.getParamValue(0, "opadminToken")
                + "&accountNumber=" + SqlTradecenter.getParamValue(0, "accountNumber");
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
        list.add(new BasicNameValuePair("token", SqlTradecenter.getParamValue(0, "opadminToken")));
        list.add(new BasicNameValuePair("accountNumber", SqlTradecenter.getParamValue(0, "accountNumber")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }
}
