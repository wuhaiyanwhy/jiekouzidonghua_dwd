package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 不频繁写入脏数据，暂时无需详细断言
 */
public class user_feedback_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "意见反馈")
    public void user_feedback_true() {
        setUrl("user.feedback.uri");
        List<NameValuePair> list = new LinkedList<>();
        //不频繁写入脏数据，先禁用
//        BasicNameValuePair param1 = new BasicNameValuePair("contacter","13000000000");
//        BasicNameValuePair param2 = new BasicNameValuePair("content","测试意见反馈");
//        list.add(param1);
//        list.add(param2);
        process(list,false,false);
    }
}
