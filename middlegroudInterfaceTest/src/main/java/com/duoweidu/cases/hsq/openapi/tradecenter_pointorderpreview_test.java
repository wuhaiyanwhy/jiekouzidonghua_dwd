package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 已切到积分入淘流程，暂时无需详细断言
 */
public class tradecenter_pointorderpreview_test extends HsqInterfaceTest {

    @Test(description = "积分订单初始化")
    public void tradecenter_pointorderpreview_true() {
        setUrl("tradecenter.pointorderpreview.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        list.add(new BasicNameValuePair("skusInfo","[{\"pSkuId\":"+ SqlDetail.getInstance().getParamValue("pSkuId") +",\"amount\":1}]"));
        process(list,false,false);
    }

}
