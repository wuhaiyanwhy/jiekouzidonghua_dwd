package com.duoweidu.cases.hsq.openapi;

import com.duoweidu.cases.interfaces.HsqInterfaceTest;
import com.duoweidu.config.HsqOpenapiConfig;
import com.duoweidu.config.sql.SqlDetail;
import com.duoweidu.model.hsq.TradecenterAssistanceordersubmitData;
import com.duoweidu.utils.ConfigFileUrl;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class TradecenterAssistanceordersubmit extends HsqInterfaceTest {

    private TradecenterAssistanceordersubmitData model;

    @Test(dependsOnGroups = "tradecenterAssistanceorderinit", description = "助力免单订单提交")
    public void tradecenterAssistanceordersubmit() {
        setUrl("tradecenter.assistanceordersubmit.uri");
        List<NameValuePair> list = new LinkedList<>();
        list.add(new BasicNameValuePair("token", SqlDetail.getInstance().getParamValue("token")));
        list.add(new BasicNameValuePair("confirmOrderSerialId", HsqOpenapiConfig.activityConfirmSid));
        list.add(new BasicNameValuePair("activityId", SqlDetail.getInstance().getParamValue(2, "activityId")));
        list.add(new BasicNameValuePair("tokactivityEventId", String.valueOf(HsqOpenapiConfig.activityEventId)));
        list.add(new BasicNameValuePair("orderType", "7"));
        list.add(new BasicNameValuePair("amount", "1"));
        list.add(new BasicNameValuePair("addressId", String.valueOf(HsqOpenapiConfig.activityAddressId)));
        list.add(new BasicNameValuePair("notes", "{}"));
        process(list,false,false);
        if ("beta".equals(ConfigFileUrl.getEnv())) {
            generalAssertTest(false);
            model = sparseJson(TradecenterAssistanceordersubmitData.class);
            detailAssert();
        }

    }

    private void detailAssert() {
        detailAssertTest("order_ids", model.order_ids);
        detailAssertTest(false, "needPay", model.needPay);
    }

}
