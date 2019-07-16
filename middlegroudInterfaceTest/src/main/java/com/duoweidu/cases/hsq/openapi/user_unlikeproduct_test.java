package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_unlikeproduct_test extends HsqInterfaceTest {

    @Test(dependsOnGroups = "loginTrue",description = "取消收藏商品")
    public void user_unlikeproduct_true() {
        setUrl("user.unlikeproduct.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("activityIds", SqlDetail.getInstance().getParamValue("pinActivitiesId")));
        process(list,true,false);
    }

}
