package com.duoweidu.cases.hsq.opadmin;

import com.duoweidu.cases.interfaces.HsqOpadminInterfaceTest;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class wechat_wechatfanslist_test extends HsqOpadminInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "微信服务号粉丝信息获取列表")
    public void wechat_wechatfanslist_true() {

        setUrl("wechat.wechatfanslist.uri");
        List<NameValuePair> list = new LinkedList<>();
        process(list, 2, true, false);
    }
}
