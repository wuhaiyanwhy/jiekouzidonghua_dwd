package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.model.hsq.UserAddaddressData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_addaddress_test extends HsqInterfaceTest {

    private UserAddaddressData model;

    @Test(dependsOnGroups = "loginTrue",description = "添加用户地址",groups = "addaddress")
    public void user_addaddress_true() {
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
        HsqOpenapiConfig.addaddressResult = result;
        model = sparseJson(UserAddaddressData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest("user_id", model.user_id);
        detailAssertTest("province_id", model.province_id);
        detailAssertTest("province", model.province);
        detailAssertTest("city_id", model.city_id);
        detailAssertTest("city", model.city);
        detailAssertTest("district_id", model.district_id);
        detailAssertTest("district", model.district);
        detailAssertTest("contacter", model.contacter);
        detailAssertTest("mobile", model.mobile);
        detailAssertTest("detail_address", model.detail_address);
        detailAssertTest("delivery_type", model.delivery_type);
        detailAssertTest("is_default", String.valueOf(model.is_default));
        detailAssertTest("id", model.id);

    }

}
