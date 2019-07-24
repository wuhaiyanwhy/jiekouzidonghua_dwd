package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class TradeCenterOpadminInterfaceTest extends InterfaceTest {

    //交易中心管理平台的接口都是一个
    {
        url = ConfigFileUrl.getUrlByKey("admin.http.uri");
        pathId = SqlDetail.getInstance().getPathId("admin.http.uri");
    }

    //get请求
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "token=" + SqlDetail.getInstance().getParamValue(0, "opadminToken")
                + "&accountNumber=" + SqlDetail.getInstance().getParamValue(0, "accountNumber");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterface.getStringResult(limitTime(), url, pathId, this.param);
    }

    //post请求
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue(0, "opadminToken")));
        list.add(new BasicNameValuePair("accountNumber", SqlDetail.getInstance().getParamValue(0, "accountNumber")));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterface.postStringResult(limitTime(), url, pathId, list);
    }
}
