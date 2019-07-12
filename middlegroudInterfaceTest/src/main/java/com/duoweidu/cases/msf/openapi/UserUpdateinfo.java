package com.duoweidu.cases.msf.openapi;

import com.duoweidu.cases.interfaces.MsfInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserUpdateinfo extends MsfInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "个人信息修改")
    public void userUpdateinfo() {
        setUrl("user.updateinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("birthday", SqlDetail.getParamValue(0, "birthday")));
        process(list,true,false);
    }
}
