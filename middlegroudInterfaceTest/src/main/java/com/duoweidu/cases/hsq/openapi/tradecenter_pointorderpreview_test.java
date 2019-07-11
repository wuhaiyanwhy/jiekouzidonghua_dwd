package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class tradecenter_pointorderpreview_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "积分订单初始化")
    public void tradecenter_pointorderpreview_true() {
        setUrl("tradecenter.pointorderpreview.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("skusInfo","[{\"pSkuId\":"+ SqlDetail.getParamValue("pSkuId") +",\"amount\":1}]"));
        process(list,false,false);
    }

}
