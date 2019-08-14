package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.generalAssert.GeneralAssert;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.ResData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class reward_coderedeem_test extends HsqInterfaceTest {

    private ResData model;

    @Test(dependsOnGroups = "orderinitPintuan", description = "兑换活动码", groups = "coderedeem")
    public void reward_coderedeem_true() {
        setUrl("reward.coderedeem.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(2, "code")));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())){
        generalAssertTest(false);
        model = sparseJson(ResData.class);
        detailAssert();
        }
    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
