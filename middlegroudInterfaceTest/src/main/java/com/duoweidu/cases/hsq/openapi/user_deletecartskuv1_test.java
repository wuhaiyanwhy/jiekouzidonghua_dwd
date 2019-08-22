package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class user_deletecartskuv1_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "addskutocart", description = "删除购物车")
    public void user_deletecartskuv1_true(){
        setUrl("user.deletecartskuv1.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("Content-Type", SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("skuIds",SqlDetail.getInstance().getParamValue("goskuId")));
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }
}
