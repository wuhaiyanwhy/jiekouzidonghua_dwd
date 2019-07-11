package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_bindprotocol_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "隐私协议")
    public void user_bindprotocol_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_BINDPROTOCOL);
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("version", SqlDetail.getParamValue("version")));
        process(list,true,false);
    }
}
