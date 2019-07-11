package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_addaddress_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户地址",groups = "addaddress")
    public void user_addaddress_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_ADDADDRESS);
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
        HsqOpenapiConfig.addaddressResult = result;
    }

}
