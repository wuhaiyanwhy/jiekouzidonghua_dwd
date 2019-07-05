package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Comment extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "评论")
    public void commentTrue() {
        setUrl("comment.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("content","好"));
        list.add(new BasicNameValuePair("item_level","5"));
        list.add(new BasicNameValuePair("order_id", SqlDetail.getParamValue("orderId")));
        list.add(new BasicNameValuePair("service_level","5"));
        process(list,false,false);

    }

}
