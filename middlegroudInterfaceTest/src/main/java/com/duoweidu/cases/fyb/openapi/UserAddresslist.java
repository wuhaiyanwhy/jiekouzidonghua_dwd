package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import com.duoweidu.model.hsq.UserAddresslistData;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddresslist extends FybInterfaceTest {

    private UserAddresslistData model;

    @Test(description = "用户地址列表")
    public void userAddresslist() {
        setUrl("user.addresslist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);
        model = sparseJson(UserAddresslistData.class);
        detailAssert();
    }

    private void detailAssert() {
        for (int i = 0; i < model.list.size(); i++) {
            assertNotEmpty("list.get(i).id", model.list.get(i).id);
            assertNotEmpty("list.get(i).user_id", model.list.get(i).user_id);
            assertNotEmpty("list.get(i).province_id", model.list.get(i).province_id);
            assertNotEmpty("list.get(i).province", model.list.get(i).province);
            assertNotEmpty("list.get(i).city_id", model.list.get(i).city_id);
            assertNotEmpty("list.get(i).city", model.list.get(i).city);
            assertNotEmpty("list.get(i).district_id", model.list.get(i).district_id);
            assertNotEmpty("list.get(i).district", model.list.get(i).district);
            assertNotEmpty("list.get(i).contacter", model.list.get(i).contacter);
            assertNotEmpty("list.get(i).mobile", model.list.get(i).mobile);
            assertNotEmpty("list.get(i).detail_address", model.list.get(i).detail_address);
            assertNotEmpty("list.get(i).delivery_type", model.list.get(i).delivery_type);
            assertNotEmpty("list.get(i).is_default", String.valueOf(model.list.get(i).is_default));

        }
    }
}
