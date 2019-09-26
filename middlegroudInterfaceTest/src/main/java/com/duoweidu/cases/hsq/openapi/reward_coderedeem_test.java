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

    private void rewardCodeRedeem(List<NameValuePair> list) {
        setUrl("reward.coderedeem.uri");
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())){
            generalAssertTest(false);
            model = sparseJson(ResData.class);
            detailAssert();
        }
    }

    @Test(dependsOnGroups = "orderinitPintuan", description = "兑换活动码", groups = "coderedeem")
    public void reward_coderedeem_true() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(2, "code")));
        rewardCodeRedeem(list);
    }

    @Test(dependsOnGroups = "orderinitPintuan", description = "兑换活动码（商家优惠券-店铺通用券）")
    public void rewardCoderedeemMerchant1() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(2, "codeMerchant1")));
        list.add(new BasicNameValuePair("type", "0"));

        rewardCodeRedeem(list);

    }

    @Test(dependsOnGroups = "orderinitPintuan", description = "兑换活动码（商家优惠券-店铺部分商品可用券）")
    public void rewardCoderedeemMerchant2() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(2, "codeMerchant2")));
        list.add(new BasicNameValuePair("type", "0"));

        rewardCodeRedeem(list);

    }

    @Test(dependsOnGroups = "orderinitPintuan", description = "兑换活动码（普通商品可用券）")
    public void rewardCoderedeemSku() {
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("code", SqlDetail.getInstance().getParamValue(2, "codeSku")));
        list.add(new BasicNameValuePair("type", "1"));

        rewardCodeRedeem(list);

    }

    private void detailAssert() {
        detailAssertTest(true, "res", model.res);
    }

}
