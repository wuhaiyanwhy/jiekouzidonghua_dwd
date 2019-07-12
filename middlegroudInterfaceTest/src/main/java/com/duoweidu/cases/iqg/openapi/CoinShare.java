package com.duoweidu.cases.iqg.openapi;

import com.duoweidu.cases.interfaces.IqgInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class CoinShare extends IqgInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "分享得金币")
    public void coin_share_true() {
        setUrl("coin.share.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("id", SqlDetail.getParamValue(2, "activityId")));
        list.add(new BasicNameValuePair("shareType","bargain"));
        process(list,false,false);
    }
}
