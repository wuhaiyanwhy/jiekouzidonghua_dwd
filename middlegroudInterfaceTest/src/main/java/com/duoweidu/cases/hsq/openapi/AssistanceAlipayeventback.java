package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class AssistanceAlipayeventback extends HsqInterfaceTest {

    @Test(description = "帮忙助力")
    public void assistanceAlipayeventback() {
        setUrl("assistance.alipayeventback.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
        list.add(new BasicNameValuePair("eventId", SqlDetail.getParamValue(2, "noPayActivityEventId")));
        list.add(new BasicNameValuePair("activityType", "1"));
        process(list, false, false);
    }
}
