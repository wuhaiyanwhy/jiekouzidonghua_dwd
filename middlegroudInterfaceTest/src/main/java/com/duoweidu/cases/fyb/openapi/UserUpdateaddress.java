package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.config.TraverseConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.fyb.UserUpdateaddressData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserUpdateaddress extends FybInterfaceTest {

    private UserUpdateaddressData model;

    @Test(description = "更新用户地址")
    public void userUpdateaddress() {
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
        model = sparseJson(UserUpdateaddressData.class);
        detailAssert();
    }

    private void detailAssert() {
        Map<String, Object> mapData = TraverseConfig.traverseObj(model);
        for (Map.Entry<String, Object> entry:
             mapData.entrySet()) {
            assertNotEmpty(entry.getKey(), entry.getValue());
        }
    }
}
