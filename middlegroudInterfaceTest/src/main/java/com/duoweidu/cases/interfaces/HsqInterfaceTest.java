package com.duoweidu.cases.interfaces;

import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.utils.CallbackInterface;
import com.duoweidu.utils.Uuid;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.UUID;

public class HsqInterfaceTest extends InterfaceTest {

    //get请求，不要断言
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid()
                + "&v=" + SqlDetail.getInstance().getParamValue(0, "v1");
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterface.getStringResult(limitTime(), url, pathId, this.param);
    }

    //post请求,不要断言
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("interface_uuid", Uuid.getUuid()));
        list.add(new BasicNameValuePair("v", SqlDetail.getInstance().getParamValue(0, "v")));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterface.postStringResult(limitTime(), url, pathId, list);
    }


}
