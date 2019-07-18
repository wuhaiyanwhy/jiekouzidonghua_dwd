package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class HsqInterfaceTest extends InterfaceTest {

    //get请求，不要断言
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "v=" + SqlDetail.getInstance().getParamValue(0, "v");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        result = CallbackInterface.getStringResult(url, pathId, this.param);
    }

    //post请求,不要断言
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("v", SqlDetail.getInstance().getParamValue(0, "v")));
        param = list.toString();
        result = CallbackInterface.postStringResult(url, pathId, list);
    }


}
