package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_bindprotocol_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "loginTrue",description = "隐私协议")
    public void user_bindprotocol_true() {
        setUrl("user.bindprotocol.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("version", SqlDetail.getInstance().getParamValue("version")));
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
