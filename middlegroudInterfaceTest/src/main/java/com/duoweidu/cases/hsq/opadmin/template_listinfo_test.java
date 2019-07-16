package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class template_listinfo_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "首页模板配置列表")
    public void template_listinfo_true() {

        setUrl("template.listinfo.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pageNum", "1"));
        list.add(new BasicNameValuePair("pageLimit", "20"));
        list.add(new BasicNameValuePair("title", ""));
        list.add(new BasicNameValuePair("start_time", ""));
        list.add(new BasicNameValuePair("end_time", ""));
        list.add(new BasicNameValuePair("date_range", "[]"));
        list.add(new BasicNameValuePair("status", "1"));
        list.add(new BasicNameValuePair("channel", "1"));
        process(list, true, true);
    }
}
