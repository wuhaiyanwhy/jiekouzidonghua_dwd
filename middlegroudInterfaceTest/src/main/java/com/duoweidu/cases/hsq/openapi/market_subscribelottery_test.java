package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class market_subscribelottery_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "订阅抽奖团")
    public void market_subscribelottery_true() {
        setUrl("market.subscribelottery.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("pinActivitiesId", SqlDetail.getInstance().getParamValue("chouActivitiesId")));
        list.add(new BasicNameValuePair("type", "1"));
        process(list,true,false);
    }

}
