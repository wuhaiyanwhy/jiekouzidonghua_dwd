package com.duoweidu.cases.fyb.openapi;

import com.duoweidu.cases.interfaces.FybInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserFeedback extends FybInterfaceTest {

    @Test(description = "意见反馈")
    public void userFeedback() {
        setUrl("user.feedback.uri");
        List<NameValuePair> list = new LinkedList<>();
        //不频繁写入脏数据，先禁用
//        BasicNameValuePair param1 = new BasicNameValuePair("contacter","13000000000");
//        BasicNameValuePair param2 = new BasicNameValuePair("content","测试意见反馈");
//        list.add(param1);
//        list.add(param2);
        process(list,true,false);
    }
}
