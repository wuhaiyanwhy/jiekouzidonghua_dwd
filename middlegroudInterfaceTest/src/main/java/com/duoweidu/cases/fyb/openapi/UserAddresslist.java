package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddresslist extends FybInterfaceTest {

    @Test(description = "用户地址列表")
    public void userAddresslist() {
        setUrl("user.addresslist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,true);
    }
}
