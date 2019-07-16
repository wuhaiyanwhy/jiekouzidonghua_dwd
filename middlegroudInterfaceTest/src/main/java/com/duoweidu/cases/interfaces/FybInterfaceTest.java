package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class FybInterfaceTest extends InterfaceTest {

    //get请求
    @Override
    protected void process(boolean isAssert,boolean isList) {
        System.out.println(url);
        //通用参数
        String par = "v=" + SqlDetail.getInstance().getParamValue(0, "v")
                + "&token=" + SqlDetail.getInstance().getParamValue("token");
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
        list.add(new BasicNameValuePair("v", SqlDetail.getInstance().getParamValue(0, "v")));
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
        if (isAssert == true) {
            generalAssertTest(isList);
        }
    }
}
