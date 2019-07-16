package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_updateaddress_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新地址")
    public void user_updateaddress_true() {
        setUrl("user.updateaddress.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("addressId", SqlDetail.getInstance().getParamValue("addressId")));
        list.add(new BasicNameValuePair("city","上海市"));
        list.add(new BasicNameValuePair("cityId","857"));
        list.add(new BasicNameValuePair("contacter","测试"));
        list.add(new BasicNameValuePair("detailAddress","测试地址"));
        list.add(new BasicNameValuePair("district","黄浦区"));
        list.add(new BasicNameValuePair("province","上海"));
        list.add(new BasicNameValuePair("provinceId","857"));
        list.add(new BasicNameValuePair("mobile","13800000000"));
        process(list,true,false);
    }
}
