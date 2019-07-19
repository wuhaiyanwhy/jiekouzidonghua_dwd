package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class tradecenter_pointordersubmit_test extends HsqInterfaceTest {

    @Test(description = "积分购提交订单")
    public void tradecenter_pointordersubmit_true() {
        setUrl("tradecenter.pointordersubmit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        list.add(new BasicNameValuePair("skusInfo","[{\"pSkuId\":" + SqlDetail.getInstance().getParamValue("pSkuId") + ",\"amount\":1}]"));
        list.add(new BasicNameValuePair("addressId","596"));
        process(list,false,false);
    }

}
