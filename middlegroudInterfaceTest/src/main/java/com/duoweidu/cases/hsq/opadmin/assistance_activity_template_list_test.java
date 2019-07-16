package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class assistance_activity_template_list_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "助力免单分享模板列表")
    public void assistance_activity_template_list_true() {

        setUrl("assistance.activity.template.list.uri");

        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("assistanceChannel", "1"));
        list.add(new BasicNameValuePair("sEcho", "1"));
        list.add(new BasicNameValuePair("iColumns", "4"));
        list.add(new BasicNameValuePair("sColumns", "%2C%2C%2C"));
        list.add(new BasicNameValuePair("iDisplayStart", "0"));
        list.add(new BasicNameValuePair("iDisplayLength", "10"));
        list.add(new BasicNameValuePair("mDataProp_0", "id"));
        list.add(new BasicNameValuePair("mDataProp_1", "title"));
        list.add(new BasicNameValuePair("mDataProp_2", "status"));
        list.add(new BasicNameValuePair("mDataProp_3", "status"));
        list.add(new BasicNameValuePair("_", "1534754527647"));

        process(list,2,true,false);

    }
}
