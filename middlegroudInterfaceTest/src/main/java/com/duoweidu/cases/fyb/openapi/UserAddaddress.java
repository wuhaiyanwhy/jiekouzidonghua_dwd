package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.FybConfig;
import com.duoweidu.model.hsq.UserAddaddressData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddaddress extends FybInterfaceTest {

    private UserAddaddressData model;

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

        model = sparseJson(UserAddaddressData.class);
        detailAssert();
    }

    private void detailAssert() {
        assertNotEmpty("user_id", model.user_id);
        assertNotEmpty("province_id", model.province_id);
        assertNotEmpty("province", model.province);
        assertNotEmpty("city_id", model.city_id);
        assertNotEmpty("city", model.city);
        assertNotEmpty("district_id", model.district_id);
        assertNotEmpty("district", model.district);
        assertNotEmpty("contacter", model.contacter);
        assertNotEmpty("mobile", model.mobile);
        assertNotEmpty("detail_address", model.detail_address);
        assertNotEmpty("delivery_type", model.delivery_type);
        assertNotEmpty("is_default", String.valueOf(model.is_default));
        assertNotEmpty("id", model.id);

    }
}
