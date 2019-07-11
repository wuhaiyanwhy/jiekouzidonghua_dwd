package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class user_getudesk_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取udesk信息")
    public void user_getudesk_true() throws IOException {
        url = ConfigFileUrl.getUrlByKey(ConfigFileUrl.USER_GETUDESK);
        List<NameValuePair> list = new LinkedList<>();
        process(list,true,false);
    }
}
