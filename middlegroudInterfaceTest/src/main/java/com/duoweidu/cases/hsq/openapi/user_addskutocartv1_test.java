package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
public class user_addskutocartv1_test extends HsqInterfaceTest {

    private ResData model;

    List<NameValuePair> list = new LinkedList<>();
    public void getParam(){
        list.add(new BasicNameValuePair("Content-Type",SqlDetail.getInstance().getParamValue(0,"Content-Type")));
        list.add(new BasicNameValuePair("skuId", SqlDetail.getInstance().getParamValue("goskuId")));
        list.add(new BasicNameValuePair("amount", SqlDetail.getInstance().getParamValue("goamount")));
    }


    @Test(dependsOnGroups = "loginTrue", description = "加入购物车", groups = "addskutocart")
    public void user_addskutocartv1_true(){
        setUrl("user.addskutocartv1.uri");
        getParam();
        list.add(new BasicNameValuePair("type", SqlDetail.getInstance().getParamValue("gotype")));
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    @Test(dependsOnGroups = "loginTrue", description = "加入购物车")
    public void user_addskutocartv1_true2(){
        setUrl("user.addskutocartv1.uri");
        getParam();
        list.add(new BasicNameValuePair("type", SqlDetail.getInstance().getParamValue("gotype2")));
        process(list,true,false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
