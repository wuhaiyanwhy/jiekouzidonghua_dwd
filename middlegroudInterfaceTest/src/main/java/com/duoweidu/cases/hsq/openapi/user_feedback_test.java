package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_feedback_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "意见反馈")
    public void user_feedback_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_FEEDBACK);
        List<NameValuePair> list = new LinkedList<>();
        //不频繁写入脏数据，先禁用
//        BasicNameValuePair param1 = new BasicNameValuePair("contacter","13000000000");
//        BasicNameValuePair param2 = new BasicNameValuePair("content","测试意见反馈");
//        list.add(param1);
//        list.add(param2);
        process(list,false,false);
    }
}
