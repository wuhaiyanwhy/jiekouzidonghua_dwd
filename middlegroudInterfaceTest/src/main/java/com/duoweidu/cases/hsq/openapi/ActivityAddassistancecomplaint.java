package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class ActivityAddassistancecomplaint extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "助力免单用户投诉")
    public void activityAddassistancecomplaint() {
        setUrl("activity.addassistancecomplaint.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("message", "test"));
        list.add(new BasicNameValuePair("type_id", "1"));
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            list.add(new BasicNameValuePair("token", SqlDetail.getParamValue("token")));
            process(list, true, false);
            model = sparseJson(ResData.class);
            detailAssert();
        }else {
            process(list,false,false);
        }
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
