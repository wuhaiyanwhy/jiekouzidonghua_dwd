package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_likeproduct_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "收藏商品")
    public void user_likeproduct_true() {
        setUrl("user.likeproduct.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue("pinActivitiesId")));
        list.add(new BasicNameValuePair("skuIds", SqlDetail.getInstance().getParamValue("skuId")));
        process(list,true,false);
    }
}
