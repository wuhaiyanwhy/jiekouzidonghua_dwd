package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddaddress extends FybInterfaceTest {

    @Test(description = "添加用户地址",groups = "userAddaddress")
    public void userAddaddress() {
        setUrl("user.addaddress.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("provinceId","2"));
        list.add(new BasicNameValuePair("province","北京"));
        list.add(new BasicNameValuePair("city","北京市"));
        list.add(new BasicNameValuePair("district","东城区"));
        list.add(new BasicNameValuePair("contacter","zz"));
        list.add(new BasicNameValuePair("mobile","15921932921"));
        list.add(new BasicNameValuePair("detailAddress","123"));
        list.add(new BasicNameValuePair("cityId","2"));
        list.add(new BasicNameValuePair("districtId","3"));
        list.add(new BasicNameValuePair("page","AddressPrecessActivity"));
        list.add(new BasicNameValuePair("location","121.430523,31.160686"));
        list.add(new BasicNameValuePair("statId","865863022045087"));
        process(list,true,false);
        //addaddress接口的返回数据确定默认值
        FybConfig.addaddressResult = result;
    }
}
