package com.duoweidu.cases.interfaces;

import com.duoweidu.utils.CallbackInterfaceChannel;
import com.duoweidu.utils.ConfigFileUrl;
import com.duoweidu.utils.Uuid;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class
HsqMerchantInterfaceTest extends InterfaceTest {

    @Override
    protected long limitTime() {
        return ConfigFileUrl.getLimitTime1();
    }

    @Override
    public int channel_id() {
        return ConfigFileUrl.getChannel2();
    }

    //get请求，不要断言
    @Override
    protected void process() {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid();
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.getStringResult(channel_id(), limitTime(), url, pathId, this.param);
    }

    //post请求,不要断言
    @Override
    protected void process(List<NameValuePair> list) {
        System.out.println(url);
        //通用参数
        list.add(new BasicNameValuePair("interface_uuid", Uuid.getUuid()));
        param = URLEncodedUtils.format(list, "Utf-8");
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.postStringResult(channel_id(), limitTime(), url, pathId, list);
    }

    //post（json传参）请求,不要断言
    @Override
    protected void process(String param) {
        System.out.println(url);
        //通用参数
        String par = "interface_uuid=" + Uuid.getUuid();
        if (param != null) {
            this.param = par + "&" + param;
        }else {
            this.param = par;
        }
        System.out.println("参数：" + param);
        result = CallbackInterfaceChannel.postStringResult(channel_id(), limitTime(), url, pathId, param);
    }
}
