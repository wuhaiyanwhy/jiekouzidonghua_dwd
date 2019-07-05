package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserChangeMyprofile extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新用户地址")
    public void user_change_myprofile_true() {
        setUrl("user.change_myprofile.uri");
        List<NameValuePair> list = new LinkedList<>();
//        list.add(new BasicNameValuePair("username","tttt"));
        process(list,true,false);
    }

}
