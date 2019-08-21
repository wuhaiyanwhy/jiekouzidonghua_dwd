package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserAddusergradeTest extends HsqInterfaceTest {

    private ResData model;

    @Test(description = "用户Riskgo评分回传-营销反作弊")
    public void userAddusergradeMarketing() {
        commonParameters("RISKGO_MARKETANTICHEAT");
    }

    @Test(description = "用户Riskgo评分回传-异业联盟")
    public void userAddusergradeAlliance() {
        commonParameters("RISKGO_CROSSOVER");
    }

    public void commonParameters(String scene){
        setUrl("user.addusergrade.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("point_token")));
        list.add(new BasicNameValuePair("risk_result", "{\"riskinfo_anticheat_common\":\"rank1\",\"riskinfo_anticheat_common_infocode\":\"2278\"}"));
        list.add(new BasicNameValuePair("unique_id", "0a6e405615657639955524641e61b6"));
        list.add(new BasicNameValuePair("scene", scene));
        process(list, true, false);
        model = sparseJson(ResData.class);
        detailAssert();
    }

    private void detailAssert(){
        assertTrue("res", model.res);
    }
}
